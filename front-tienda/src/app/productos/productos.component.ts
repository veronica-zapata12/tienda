import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
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
  estado = ["Creado", "Agotado", "Inabilitado"];
  habilitarProducto: boolean;
  habilitarCategoria: boolean;
  productos: Producto[] = [];
  categorias: Categoria[]=[];
  addCategoria: Categoria = {
    id: 0,
    nombre: ""

  };
  aux=[]
  aux2:Categoria;
  categorias2: Observable<Categoria[]>;
  paginaActual = 1;
  paginaActualBuscar = 1;
  productoForm: FormGroup;
  idForm: FormGroup;
  productoEncontrado: Producto;
  productoCategoriaEncontrado: Categoria[] = [];
  @ViewChild("botonCerrar") botonCerrar: ElementRef;
  constructor(protected productoService: ProductosService) { }

  ngOnInit(): void {
    this.getProductos();
    this.construirFormulario();
    this.getCategorias();

  }
  getProductos() {
    this.productoService.consultarTodosProductos().subscribe(producto => {
      this.productos = producto;

    });
  }
  getCategorias() {
    this.productoService.consultarTodosCategoria().subscribe(categoria => {
      this.categorias = categoria
    })
  }
  crear() {
    //this.validarCategoria();
    //console.log(this.productoForm.value);
    let cat = this.productoForm.get('categoria').value
    this.productoService.consultarTodosCategoria().subscribe((categoria:Categoria[]) => {
      this.categorias = categoria
      console.log(this.categorias);
      let catt = this.categorias.filter(x => x.id == cat)
      console.log(catt[0].id);
      console.log(catt[0].nombre);
      this.addCategoria.id=catt[0].id;
      this.addCategoria.nombre=catt[0].nombre
      console.log(this.addCategoria);
      
      this.aux.push(this.addCategoria)
      this.aux2=this.addCategoria;
      //this.aux2.nombre=catt[0].nombre;

     this.productoForm.get('categoria').setValue(this.aux)
     console.log(this.productoForm.get('categoria').value);
     
       console.log(this.productoForm.value);
      

    
    }); 
    console.log(this.addCategoria);
    ;
    
   
    /*this.categorias2=this.productoService.consultarTodosCategoria();
    let uno=this.categorias2.forEach(categoria=>
    //this.aux.push(categoria)
    console.log(categoria.length)
    
    );

    let cat:number=0
    console.log(uno)
     cat = this.productoForm.get('categoria').value
     let i=2;
    console.log(cat);
    this.aux2=this.aux;
    let catt = this.aux2.findIndex(x => x.id == i);
    let oo=this.aux2[0];
    console.log(this.aux)
    //console.log(oo);
    console.log(this.aux.length);*/
    
    
    
    //return this.aux
    
   
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
  habilitar(nombre: String) {
    console.log(nombre);

    if (nombre == "producto") {
      this.habilitarProducto = true;
      this.habilitarCategoria = false
    } else
      if (nombre == "categoria") {
        this.habilitarCategoria = true;
        this.habilitarProducto = false;
      }
  }
 
 validarCategoria() {
    const cat = this.productoForm.get('categoria').value
    console.log(cat);
    
    this.productoService.consultarTodosCategoria().forEach((categoria:Categoria[]) => {
      this.categorias = categoria
      const catt = this.categorias.filter(x => x.id == cat);
      console.log(catt);
      //this.categorias2= this.categorias.filter(x => x.id == cat)
      this.addCategoria.id= catt[0].id;
      this.addCategoria.nombre = catt[0].nombre;
      this.aux=catt;
      

    console.log(this.categorias2);

    
    });
    this.productoForm.get('categoria').setValue(this.aux);
    console.log(this.productoForm.get('categoria').value);
    
    
    
  }

  consultarPorId(id: number) {
    const metodo = this.idForm.get('metodo').value;
    console.log(id);

    if (metodo === "producto") {
      this.productoService.consultarPorIdProductos(id).subscribe(producto => {
        this.productoEncontrado = producto;

        if (null == this.productoEncontrado) {
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
      
    } else {
      this.productoEncontrado=null;
      if (metodo === "categoria") {
        
        this.productoService.consultarProductosPorCategoria(id).subscribe(producto => {
          this.productoCategoriaEncontrado = producto;
          if (this.productoCategoriaEncontrado.length <= 0) {
            Swal.fire({
              position: 'center',
              icon: 'error',
              title: 'La categoria no ha sido encontrada',
              showConfirmButton: false,
              showCancelButton: true,
              cancelButtonText: 'Ok!'

            });

          }//
        });

      
      
      }
      this.construirFormulario();




    }

    


  }



  construirFormulario() {
    this.productoForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      cantidad: new FormControl('', [Validators.required]),
      precio: new FormControl('', [Validators.required]),
      estado: new FormControl('', [Validators.required]),
      categoria: new FormControl('', [Validators.required])
    });
    this.idForm = new FormGroup({
      id: new FormControl(''),
      metodo: new FormControl('')
    });
    this.productoEncontrado = null;
    this.productoCategoriaEncontrado = [];
  }
  get form() {
    return this.productoForm.controls;
  }
  cerrarModal() {
    this.botonCerrar.nativeElement.click();
    this.construirFormulario();
    this.habilitarCategoria=false;
    this.habilitarProducto=false;
    this.productoEncontrado = null;
    this.productoCategoriaEncontrado = [];
  }
}
