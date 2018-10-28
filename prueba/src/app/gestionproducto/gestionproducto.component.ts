import { Component, OnInit } from '@angular/core';
import { InvocarService } from '../invocar.service';

@Component({
  selector: 'app-gestionproducto',
  templateUrl: './gestionproducto.component.html',
  styleUrls: ['./gestionproducto.component.css']
})
export class GestionproductoComponent implements OnInit {
  titlep = 'GESTION PRODUCTOS';
  codigoproducto: String;
  producto: String;
  marca: String;
  tipo: String;
  constructor(private inv: InvocarService) { }

  ngOnInit() {
  }

  public guardarProducto() {
    this.inv.ingresaProducto(this.codigoproducto, this.producto, this.marca, this.tipo);
    alert('INFORMACION ALAMACENADA CORRECTAMETE');
    window.location.href = '/principal';
  }
}
