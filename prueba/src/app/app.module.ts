import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InvocarService } from './invocar.service';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app.routes';
import { InicioComponent } from './inicio/inicio.component';
import { PrincipalComponent } from './principal/principal.component';
import { GestionproductoComponent } from './gestionproducto/gestionproducto.component';
import { GestionbodegaComponent } from './gestionbodega/gestionbodega.component';
import { ListaproductosComponent } from './listaproductos/listaproductos.component';






@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    PrincipalComponent,
    GestionproductoComponent,
    GestionbodegaComponent,
    ListaproductosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [InvocarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
