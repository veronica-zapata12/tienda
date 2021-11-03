import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Categoria } from '../modelo/categoria';
import { Producto } from '../modelo/producto';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor( protected http:HttpService) { }

  public crear(producto: Producto) {
 
 
    return this.http.doPost(`${environment.endpoint}productos`,producto,this.http.optsName('crear producto'));
  }
  public consultarTodosProductos() {
    return this.http.doGet<Producto[]>(`${environment.endpoint}productos`);
  } 
  public consultarPorIdProductos(id:number){
    return this.http.doGetParameters<Producto>(`${environment.endpoint}productos/${id}`);
  }
  public consultarTodosCategoria() {
    return this.http.doGet<Categoria[]>(`${environment.endpoint}productos/categoria`);
  } 
  public consultarProductosPorCategoria(id:number) {
    return this.http.doGet<Categoria[]>(`${environment.endpoint}productos/categoria/${id}`);
  } 
}
