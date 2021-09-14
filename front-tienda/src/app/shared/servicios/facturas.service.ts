import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { DetallesFactura } from '../modelo/detallesFactura';
import { Factura } from '../modelo/factura';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class FacturasService {

  constructor( protected http:HttpService) { }

  public guardar(factura: Factura) {
    factura.id=122 
    return this.http.doPost(`${environment.endpoint}factura`,factura,this.http.optsName('crear persona'));
  }
  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || "server error.");
  }
  public consultarTodos() {
    return this.http.doGet<Factura[]>(`${environment.endpoint}factura`);
  } 
  public consultarPorId(id:number){
    return this.http.doGetParameters<Factura>(`${environment.endpoint}factura/${id}`);
  }
  public consultarDetalles(id:number){
    return this.http.doGetParameters<DetallesFactura[]>(`${environment.endpoint}factura/detalles/${id}`);
  }
}
