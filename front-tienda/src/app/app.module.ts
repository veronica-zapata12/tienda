import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { InicioComponent } from './inicio/inicio.component';
import { CabeceroComponent } from './cabecero/cabecero.component';
import { CrearProductoComponent } from './productos/crear-producto/crear-producto.component';
import { ListarProductoComponent } from './productos/listar-producto/listar-producto.component';
import { CrearFacturaComponent } from './facturas/crear-factura/crear-factura.component';
import { ListarFacturasComponent } from './facturas/listar-facturas/listar-facturas.component';
import { FacturasComponent } from './facturas/facturas.component';
import { PersonasComponent } from './personas/personas.component';
import { ProductosComponent } from './productos/productos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { PersonasService } from './shared/servicios/personas.service';
import { HttpService } from './shared/servicios/http.service';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    PersonasComponent,
    FacturasComponent,
    ProductosComponent,
    InicioComponent,
    CabeceroComponent,
    CrearProductoComponent,
    ListarProductoComponent,
    CrearFacturaComponent,
    ListarFacturasComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [PersonasService,HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
