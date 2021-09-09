import { Categoria } from "./categoria";

export interface Producto{
    id?:number,
    nombre:String,
    descripcion:string,
    fecha?:Date
    cantidad:number,
    precio:number,
    estado:string,
    categoria:Categoria

}