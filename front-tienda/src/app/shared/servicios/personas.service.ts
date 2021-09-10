import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Persona } from '../modelo/persona';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {

  constructor( protected http:HttpService) { }

  public guardar(persona: Persona) {
 
    return this.http.doPost(`${environment.endpoint}personas`,persona,this.http.optsName('crear persona'));
  }
  public consultarTodos() {
    return this.http.doGet<Persona[]>(`${environment.endpoint}personas`);
  } 
  public consultarPorId(id:number){
    return this.http.doGetParameters<Persona>(`${environment.endpoint}personas/${id}`);
  }
}
