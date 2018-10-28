import { Component, OnInit } from '@angular/core';
import { InvocarService } from '../invocar.service';

@Component({
  selector: 'app-listaproductos',
  templateUrl: './listaproductos.component.html',
  styleUrls: ['./listaproductos.component.css']
})
export class ListaproductosComponent implements OnInit {
producto: any[] = [
    {
      'name': 'Douglas  Pace', 'prod' : 'este man'
    },
    {
      'name': 'Mcleod  Mueller', 'prod' : 'este man'
    },
    {
      'name': 'Day  Meyers', 'prod' : 'este man'
    },
    {
      'name': 'Aguirre  Ellis', 'prod' : 'este man'
    },
    {
      'name': 'Cook  Tyson', 'prod' : 'este man'
    }
  ];
  constructor(private inv: InvocarService) { }

  ngOnInit() {
  }

  public getProductos() {
    this.inv.listarProductos();
  }

}
