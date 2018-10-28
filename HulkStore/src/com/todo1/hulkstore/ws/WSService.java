package com.todo1.hulkstore.ws;

import com.todo1.hulkstore.servicios.ProductoServicio;

public class WSService {

	ProductoServicio srv = new ProductoServicio();
	
	public void ingresarProducto() {
		//Producto p = new Producto();
		srv.moverProducto("{codigoproducto=abc;producto=nuevo producto;marca=marvel;tipo=vaso}", "INGRESO");
	}
}
