package com.todo1.hulkstore.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.todo1.hulkstore.modelos.Bodega;
import com.todo1.hulkstore.modelos.Kardex;
import com.todo1.hulkstore.modelos.Producto;
import com.todo1.hulkstore.servicios.Inicio;
import com.todo1.hulkstore.utils.Constantes;

public class ProductoDao {

public void moverProducto(Producto producto, String tipoMovimiento) {
		
	}
	
	public void guardarProducto(Producto producto) {
		HttpSession sesion = Inicio.sesion;
		
		List<Producto> listaProductos = new ArrayList<>();
		
		if(sesion.getAttribute(Constantes.PRODUCTOS) == null) {
			System.out.println("esta vacia");
			sesion.setAttribute(Constantes.PRODUCTOS, listaProductos);
		}
		
		listaProductos = (List<Producto>)sesion.getAttribute(Constantes.PRODUCTOS);
		
		if(listaProductos.isEmpty())
			producto.setCodigo(1);
		else
			producto.setCodigo(listaProductos.size()+1);
		
		listaProductos.add(producto);
		
		sesion.removeAttribute(Constantes.PRODUCTOS);
		
		sesion.setAttribute(Constantes.PRODUCTOS, listaProductos);
	}
	
	
	public String consultarProductos() {
		HttpSession sesion = Inicio.sesion;
		
		StringBuilder respuesta = new StringBuilder();
		
		if(sesion.getAttribute(Constantes.PRODUCTOS) == null) {
			System.out.println("no existen producto");
		}else {
			List<Producto> listaProductos = (List<Producto>)sesion.getAttribute(Constantes.PRODUCTOS);
			
			for(Producto p : listaProductos) {
				respuesta.append("producto:");
				respuesta.append(p.getCodigo());
				respuesta.append(",");
				respuesta.append(p.getCodigoProducto());
				respuesta.append(",");
				respuesta.append(p.getProducto());
				respuesta.append(",");
				respuesta.append(p.getMarca());
				respuesta.append(",");
				respuesta.append(p.getTipo());
				respuesta.append(";");
			}
		}
		
		return respuesta.toString();
	}
	
	
	public Producto consultarProductoPorCodigo(long idProducto) {
		HttpSession sesion = Inicio.sesion;
		Producto producto = new Producto();
		
		if(sesion.getAttribute(Constantes.PRODUCTOS) == null) {
			System.out.println("no existen producto");
		}else {
			List<Producto> listaProductos = (List<Producto>)sesion.getAttribute(Constantes.PRODUCTOS);
			
			for(Producto p : listaProductos) {
				if(p.getCodigo() == idProducto) {
//					System.out.println(p.getCodigo());
//					System.out.println(p.getCodigoProducto());
//					System.out.println(p.getProducto());
					
					producto = p;
					
					break;
				}
			}
		}
		
		return producto;
	}
	
	public void registrarMovimientoProducto(Producto producto, Bodega bodega, String numeroDocumento, String tipoMovimiento, int cantidad) {
		
		HttpSession sesion = Inicio.sesion;
		
		List<Kardex> listaKardex = new ArrayList<>();
		
		if(sesion.getAttribute(Constantes.KARDEX) == null) {
			System.out.println("esta vacia");
			sesion.setAttribute(Constantes.KARDEX, listaKardex);
		}
		
		listaKardex = (List<Kardex>)sesion.getAttribute(Constantes.KARDEX);
		
		Kardex kardex = new Kardex();
		
		if(listaKardex.isEmpty()) {
			kardex.setCodigo(1);
		}
		else {
			kardex.setCodigo(listaKardex.size()+1);
		}
		
		kardex.setFechaMovimiento(new Date());
		kardex.setBodega(bodega);
		kardex.setProducto(producto);
		kardex.setNumeroDocumento(numeroDocumento);
		kardex.setTipoMovimiento(tipoMovimiento);
		kardex.setCantidad(cantidad);
		
		
		listaKardex.add(kardex);
		
		sesion.removeAttribute(Constantes.KARDEX);
		
		sesion.setAttribute(Constantes.KARDEX, listaKardex);
		
	}
	
	public String consultarKardexGlobal() {
		HttpSession sesion = Inicio.sesion;
		
		StringBuilder respuesta = new StringBuilder();
		
		if(sesion.getAttribute(Constantes.KARDEX) == null) {
			System.out.println("no existen kardex");
		}else {
			List<Kardex> listaKardex = (List<Kardex>)sesion.getAttribute(Constantes.KARDEX);
			
			for(Kardex k : listaKardex) {
				respuesta.append("kardex:");
				respuesta.append(k.getBodega().getBodega());
				respuesta.append(";");
				respuesta.append(k.getProducto().getProducto());
				respuesta.append(";");
				respuesta.append(k.getFechaMovimiento());
				respuesta.append(";");
				respuesta.append(k.getTipoMovimiento());
				respuesta.append(";");
				respuesta.append(k.getCantidad());
				respuesta.append(";");
			}
		}
		
		return respuesta.toString();
	}
	
	public String consultarKardexProducto(Producto producto) {
		HttpSession sesion = Inicio.sesion;
		
		StringBuilder respuesta = new StringBuilder();
		
		if(sesion.getAttribute(Constantes.KARDEX) == null) {
			System.out.println("no existen kardex");
		}else {
			List<Kardex> listaKardex = (List<Kardex>)sesion.getAttribute(Constantes.KARDEX);
			
			for(Kardex k : listaKardex) {
				if(k.getProducto().getCodigo() == producto.getCodigo()) {
					respuesta.append("kardex:");
					respuesta.append(k.getBodega().getBodega());
					respuesta.append(";");
					respuesta.append(k.getProducto().getProducto());
					respuesta.append(";");
					respuesta.append(k.getFechaMovimiento());
					respuesta.append(";");
					respuesta.append(k.getTipoMovimiento());
					respuesta.append(";");
					respuesta.append(k.getCantidad());
					respuesta.append(";");
					
					break;
				}
			}
		}
		
		return respuesta.toString();
	}
	
}
