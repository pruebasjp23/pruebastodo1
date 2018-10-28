import { Component, OnInit } from '@angular/core';
import { InvocarService } from '../invocar.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor(private inv: InvocarService) {
  }

  ngOnInit() {
  }

  public iniciar() {
  this.inv.inicia();

}
}
