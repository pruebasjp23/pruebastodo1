import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

import { catchError, map, tap } from 'rxjs/operators';


@Injectable()
export class InvocarService {

  customersObservable: Observable<HttpResponse<any>>;
  alguno: any;
  algunotext: String;

  constructor(private http: HttpClient) {
  }

  public inicia() {
      const heads1 = new HttpHeaders();
      heads1.append('Access-Control-Allow-Headers', 'Content-Type: text/html;charset=UTF-8');
        heads1.append('Access-Control-Allow-Methods', 'GET');
        heads1.append('Access-Control-Allow-Origin', '*');

  this.http.get('http://localhost:8080/HulkStore/iniciar', {headers: heads1}).
  subscribe(data => {
    console.log(data);
  });

}

  public guardarBodega(bodega: String) {

    this.http.get('http://localhost:8080/HulkStore/ejecutar?accion=GUARDAR_BODEGA&data=[' + bodega + ']').
  subscribe(data => {
    console.log(data);
  });

}

public ingresaProducto(codproducto: String, producto: String, marca: String, tipo: String) {

      const heads1 = new HttpHeaders();
      heads1.append('Access-Control-Allow-Headers', 'Content-Type: text/html;charset=UTF-8');
        heads1.append('Access-Control-Allow-Methods', 'GET');
        heads1.append('Access-Control-Allow-Origin', '*');

  this.http.get('http://localhost:8080/HulkStore/ejecutar?accion=GUARDAR_PRODUCTO&data=['
  + codproducto + ';' + producto + ';' + marca + ';' + tipo + ']',
   {headers: heads1}).
  subscribe(data => {
    console.log(data);
  });
}

public listarProductos() {
const heads1 = new HttpHeaders();
      heads1.append('Access-Control-Allow-Headers', 'Content-Type: text/html;charset=UTF-8');
        heads1.append('Access-Control-Allow-Methods', 'GET');
        heads1.append('Access-Control-Allow-Origin', '*');



  this.customersObservable = this.http.get<Observable<HttpResponse<any>>>
  ('http://localhost:8080/HulkStore/ejecutar?accion=CONSULTAR_PRODUCTO',
  { observe: 'response' });

  alert(this.customersObservable.subscribe(resp => {
    // resp.headers.keys();
    this.alguno = resp.body;
    this.algunotext = resp.statusText;
  }));

  alert(this.alguno);
  alert(this.algunotext);


  this.http.get('http://localhost:8080/HulkStore/ejecutar?accion=CONSULTAR_PRODUCTO', {headers: heads1})
  .subscribe(response => console.log(response));
}

}
