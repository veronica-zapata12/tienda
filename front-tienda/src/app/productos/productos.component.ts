import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Categoria } from '../shared/modelo/categoria';
import { Producto } from '../shared/modelo/producto';

import { ProductosService } from '../shared/servicios/productos.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  estado=["Creado", "Agotado","Inabilitado"];
  productos:Producto[]=[];
  categorias:Categoria[];
  addCategoria:Categoria={
    id:0,
    nombre:""

  };
  paginaActual = 1;
  paginaActualBuscar = 1;
  productoForm:FormGroup;
  idForm: FormGroup;
  productoEncontrado:Producto;
  productoCategoriaEncontrado:Categoria[]=[];
  @ViewChild("botonCerrar") botonCerrar:ElementRef;
  constructor(protected productoService:ProductosService) { }

  ngOnInit(): void {
  this.getProductos();
  this.construirFormulario();
 this.getCategorias();
    
  }
getProductos(){
  this.productoService.consultarTodosProductos().subscribe(producto=>{
    this.productos=producto;
    
  });
}
getCategorias(){
  this.productoService.consultarTodosCategoria().subscribe(categoria=>{
    this.categorias=categoria
  })
}
crear(){
  this.validarCategoria();
  
   console.log(this.productoForm.value);
   
  this.productoService.crear(this.productoForm.value).subscribe(() => {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'El producto ha sido creado con éxito',
      showConfirmButton: true,

    }); 
   this.getProductos();

  });
  
  this.cerrarModal();
  this.construirFormulario();
  
}
validarCategoria(){
  const cat=this.productoForm.get('categoria').value  
  this.productoService.consultarTodosCategoria().subscribe(categoria=>{
    this.categorias=categoria
    let catt=this.categorias.filter(x=>x.id== cat)
    this.addCategoria.id=catt[0].id;
    this.addCategoria.nombre=catt[0].nombre;
    console.log(this.addCategoria);
    
    
  });
  this.productoForm.get('categoria').setValue(this.addCategoria)
}

consultarPorId(id:number){
  const metodo=this.idForm.get('metodo').value;
  if(metodo==="producto"){
    this.productoService.consultarPorIdProductos(id).subscribe(producto=>{
      this.productoEncontrado=producto;
      
      if(null == this.productoEncontrado){
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'El producto no ha sido encontrado',
          showConfirmButton: false,
          showCancelButton: true,
          cancelButtonText: 'Ok!'
  
        });
       
      }
    });
    this.construirFormulario();
  }else{
    this.productoService.consultarProductosPorCategoria(id).subscribe(producto=>{
      this.productoCategoriaEncontrado=producto;
      if(null == this.productoCategoriaEncontrado){
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'El productono ha sido encontrado',
          showConfirmButton: false,
          showCancelButton: true,
          cancelButtonText: 'Ok!'
  
        });
       
      }
    });
    this.construirFormulario();
    
  } 
 
  
  

}  
  

 
construirFormulario(){
  this.productoForm=new FormGroup({
    nombre:new FormControl('', [Validators.required]),
    descripcion:new FormControl('', [Validators.required]),
    cantidad:new FormControl('', [Validators.required]),
    precio:new FormControl('', [Validators.required]),
    estado:new FormControl('', [Validators.required]),
    categoria:new FormControl('', [Validators.required])
  });
  this.idForm=new FormGroup({
    id:new FormControl(''),
    metodo:new FormControl('')
  });
  this.productoEncontrado=null;
  this.productoCategoriaEncontrado=[];
}
get form() {
  return this.productoForm.controls;
}
 cerrarModal(){
  this.botonCerrar.nativeElement.click();
  this.construirFormulario();
}
}
