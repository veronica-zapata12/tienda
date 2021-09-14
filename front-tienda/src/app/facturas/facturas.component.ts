import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

import Swal from 'sweetalert2';
import { DetallesFactura } from '../shared/modelo/detallesFactura';
import { Factura } from '../shared/modelo/factura';
import { FacturasService } from '../shared/servicios/facturas.service';


@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit {
  facturas:Factura[]=[];
  
detallesFactura:DetallesFactura[]=[]
paginaActual=1;
facturaForm:FormGroup;
 
@ViewChild("botonCerrar") botonCerrar:ElementRef;

@ViewChild("botonCerrar2") botonCerrar2:ElementRef;
  constructor(protected facturaService:FacturasService, private formBuilder:FormBuilder) {
    //this.refrescar();
  }

  ngOnInit(): void {
    this.getFacturas();
    this.construirFormulario();
    //this.refrescar();
    
  }
getFacturas(){
  this.facturaService.consultarTodos().subscribe(factura=>{
    this.facturas=factura;
  });
  

}

cerrarModal(){
  this.botonCerrar.nativeElement.click();
  //this.refrescar()
  this.construirFormulario();
  
}
cerrarModal2(){
  this.botonCerrar2.nativeElement.click();
  this.refrescar()
  //this.construirFormulario();
  
}
detalles(id:number){
 
  
  this.facturaService.consultarDetalles(id).subscribe(detalles=>{
    this.detallesFactura=detalles
  })

}

 

  get detalle(){
    return this.facturaForm.get('detalleFactura') as FormArray;
  }
construirFormulario(){
  this.facturaForm = this.formBuilder.group({
    personaId:[, [Validators.required,Validators.pattern("^[0-9]*$")]],
    detalleFactura: this.formBuilder.array([])
  });
}
  get form() {
    return this.facturaForm.controls;
  }
 

  agregarDetalle(){
    const telefonoFormGroup  = this.formBuilder.group({
      cantidad: '',
      precio: ''
    });
    this.detalle.push(telefonoFormGroup);
  }

  removerDetalle(indice: number) {
    this.detalle.removeAt(indice);
  }

  submit() {
    if(this.facturaForm.valid){
      this.facturaService.guardar(this.facturaForm.value).subscribe(() => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'la factura ha sido creada con éxito',
          showConfirmButton: true,
  
        });
        this.getFacturas();
       
        
      });
      this.cerrarModal2();
      //this.construirFormulario();
      
    }
  }

  refrescar() {
    this.facturaForm.patchValue({
      personaId: '',
    });
    this.detalle.controls.splice(0, this.detalle.length);
  }
}