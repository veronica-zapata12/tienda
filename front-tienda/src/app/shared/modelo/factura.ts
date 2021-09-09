import { DetallesFactura } from "./detallesFactura";
import { Persona } from "./persona";

export interface Factura{
    id?:number,
    personaId:number
    fecha?:Date
    total?:number,
    pesona?:Persona
    detallesFactura: Array<DetallesFactura>;

}