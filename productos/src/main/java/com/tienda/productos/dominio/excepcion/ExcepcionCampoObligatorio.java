package com.tienda.productos.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException{

 public ExcepcionCampoObligatorio(String mensaje){
     super(mensaje);
 }
}
