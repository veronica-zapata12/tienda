import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FacturasComponent } from './facturas/facturas.component';
import { InicioComponent } from './inicio/inicio.component';
import { PersonasComponent } from './personas/personas.component';
import { ProductosComponent } from './productos/productos.component';



const routes: Routes = [
  {path:'', component: InicioComponent},
  {path:'personas', component: PersonasComponent},
  {path:'productos', component:ProductosComponent},
  {path:'facturas', component: FacturasComponent},
  {path:'**', component:InicioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
