import { Component, OnInit } from '@angular/core';
import { InvocarService } from '../invocar.service';

@Component({
  selector: 'app-gestionbodega',
  templateUrl: './gestionbodega.component.html',
  styleUrls: ['./gestionbodega.component.css']
})
export class GestionbodegaComponent implements OnInit {
  bodega: String;
  titleb = 'GESTION BODEGAS';

  constructor(private inv: InvocarService) { }

  ngOnInit() {
  }

  public guardarBodega() {
    alert('la:' + this.bodega);
    this.inv.guardarBodega(this.bodega);
    alert('INFORMACION ALAMACENADA CORRECTAMETE');
    window.location.href = '/principal';
  }
}
