import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { InicioComponent } from './inicio/inicio.component';
import { CabeceroComponent } from './cabecero/cabecero.component';
import { FacturasComponent } from './facturas/facturas.component';
import { PersonasComponent } from './personas/personas.component';
import { ProductosComponent } from './productos/productos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { PersonasService } from './shared/servicios/personas.service';
import { HttpService } from './shared/servicios/http.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { ProductosService } from './shared/servicios/productos.service';
import { FacturasService } from './shared/servicios/facturas.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonasComponent,
    FacturasComponent,
    ProductosComponent,
    InicioComponent,
    CabeceroComponent,
   
    
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
  providers: [PersonasService,HttpService, ProductosService,FacturasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
