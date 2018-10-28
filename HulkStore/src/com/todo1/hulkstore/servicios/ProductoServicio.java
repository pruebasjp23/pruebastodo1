package com.todo1.hulkstore.servicios;

import com.todo1.hulkstore.dao.BodegaDao;
import com.todo1.hulkstore.dao.ProductoDao;
import com.todo1.hulkstore.modelos.Bodega;
import com.todo1.hulkstore.modelos.Producto;

public class ProductoServicio {
	
	
	
	public void guardarProducto(String data) {
		
		System.out.println(data);
		//{codigoproducto=abc;producto=nuevo producto;marca=marvel;tipo=vaso}
		data = data.replace("[", "");
		data = data.replace("]", "");
		
		String datos[] = data.split(";");
		
		Producto producto = new Producto();
		
		producto.setCodigoProducto(datos[0]);
		producto.setProducto(datos[1]);
		producto.setMarca(datos[2]);
		producto.setTipo(datos[3]);
		producto.setEstado(true);
		
		ProductoDao dao = new ProductoDao();
		dao.guardarProducto(producto);
		
	}
	
	public void moverProducto(String data, String tipoMovimiento) {
		System.out.println(data);
		
		data = data.replace("[", "");
		data = data.replace("]", "");
		
		String datos[] = data.split(";");
		
		//[1;1;001-123;1]
		String numeroDocumento = datos[2];
		int cantidad = Integer.parseInt(datos[3]);
		
		ProductoDao dao = new ProductoDao();
		BodegaDao bdao = new BodegaDao();
		
		Producto producto = dao.consultarProductoPorCodigo(Long.parseLong(datos[0]));
		Bodega bodega = bdao.consultarBodegaPorCodigo(Long.parseLong(datos[1]));
		
		dao.registrarMovimientoProducto(producto, bodega, numeroDocumento, tipoMovimiento, cantidad);
	}
	
	
	public String consultarProductos() {
		ProductoDao dao = new ProductoDao();
		return dao.consultarProductos();
	}
	
	public String consultarKardexGlobal() {
		ProductoDao dao = new ProductoDao();
		return dao.consultarKardexGlobal();
	}
}
