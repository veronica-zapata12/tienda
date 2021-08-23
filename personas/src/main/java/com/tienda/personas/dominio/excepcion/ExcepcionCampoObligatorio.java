package com.tienda.personas.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException{

 public ExcepcionCampoObligatorio(String mensaje){
     super(mensaje);
 }
}
