import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PrincipalComponent } from './principal/principal.component';
import { InicioComponent } from './inicio/inicio.component';
import { GestionproductoComponent } from './gestionproducto/gestionproducto.component';
import { GestionbodegaComponent } from './gestionbodega/gestionbodega.component';
import { ListaproductosComponent } from './listaproductos/listaproductos.component';


const APP_ROUTES: Routes = [
     { path: '', redirectTo: 'inicio', pathMatch: 'full' },
     { path: 'inicio', component: InicioComponent },
     { path: 'principal', component: PrincipalComponent },
     { path: 'gestionproducto', component: GestionproductoComponent },
     { path: 'gestionbodega', component: GestionbodegaComponent },
     { path: 'listaproductos', component: ListaproductosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
