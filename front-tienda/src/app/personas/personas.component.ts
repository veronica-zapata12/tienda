import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Persona } from '../shared/modelo/persona';
import { PersonasService } from '../shared/servicios/personas.service';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css']
})
export class PersonasComponent implements OnInit {
 personas:Persona[]=[];
 personaForm:FormGroup;
 idForm: FormGroup;
 buscarPersona:Persona;
 paginaActual = 1;
 @ViewChild("botonCerrar") botonCerrar:ElementRef;
  constructor(private personaService:PersonasService) { }

  ngOnInit(): void {
   this.getPersonas();
   this.construirFormulario();
  }
getPersonas(){
  this.personaService.consultarTodos().subscribe(persona =>
    this.personas=persona)
}
crear(){

  if(this.personaForm.valid){
    this.personaService.guardar(this.personaForm.value).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'la persona ha sido creada con éxito',
        showConfirmButton: true,

      });
      this.getPersonas();
      this.construirFormulario();
      this.cerrarModal();
    });
    
  }

}
private construirFormulario(){
  this.personaForm=new FormGroup({
    id:new FormControl('', [Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
    nombre:new FormControl('', [Validators.required])
  })
  this.idForm=new FormGroup({
    id:new FormControl('')
  })
  this.buscarPersona=null;
}
get form() {
  return this.personaForm.controls;
}
 cerrarModal(){
  this.botonCerrar.nativeElement.click();
  this.construirFormulario();
}
buscarPorId(id:number){
  this.personaService.consultarPorId(id).subscribe(persona=>{
    this.buscarPersona=persona;
    if(null == this.buscarPersona){
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'La persona no ha sido encontrada',
        showConfirmButton: false,
        showCancelButton: true,
        cancelButtonText: 'Ok!'

      });
      this.construirFormulario();
    }
  });
}
}
