import { Categoria } from "./categoria";

export interface Producto{
    id?:number,
    nombre:String,
    descripcion:string,
    creacion?:string,
    cantidad:number,
    precio:number,
    estado:string,
    categoria:Categoria

}