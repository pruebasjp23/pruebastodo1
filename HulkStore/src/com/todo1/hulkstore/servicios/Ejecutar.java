package com.todo1.hulkstore.servicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo1.hulkstore.utils.Constantes;

public class Ejecutar extends HttpServlet {

	private static final long serialVersionUID = 1413121523837004252L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		System.out.println(request.getParameter(Constantes.accion));
		
		String respuesta = "OK";
		
		if(Constantes.INGRESO.equals(request.getParameter(Constantes.accion))) {
			ProductoServicio srv = new ProductoServicio();
			srv.moverProducto(request.getParameter(Constantes.data), Constantes.INGRESO);
		}
		if(Constantes.EGRESO.equals(request.getParameter(Constantes.accion))) {
			ProductoServicio srv = new ProductoServicio();
			srv.moverProducto(request.getParameter(Constantes.data), Constantes.EGRESO);
		}
		if(Constantes.GUARDAR_PRODUCTO.equals(request.getParameter(Constantes.accion))) {
			ProductoServicio srv = new ProductoServicio();
			srv.guardarProducto(request.getParameter(Constantes.data));
		}
		if(Constantes.CONSULTAR_PRODUCTO.equals(request.getParameter(Constantes.accion))) {
			ProductoServicio srv = new ProductoServicio();
			respuesta = srv.consultarProductos();
		}
		if(Constantes.GUARDAR_BODEGA.equals(request.getParameter(Constantes.accion))) {
			BodegaServicio srv = new BodegaServicio();
			srv.guardarBodega(request.getParameter(Constantes.data));
		}
		if(Constantes.CONSULTAR_KARDEX.equals(request.getParameter(Constantes.accion))) {
			ProductoServicio srv = new ProductoServicio();
			respuesta = srv.consultarKardexGlobal();
		}
		
		response.resetBuffer();
		response.setContentType("text/html;charset=UTF-8");
		response.setBufferSize(1024 * 1024); //  
		
		//if(respuesta.equalsIgnoreCase("OK"))
			response.setStatus(HttpServletResponse.SC_OK);
//		else{
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST, respuesta);
//		}
		
		response.getWriter().println(respuesta);
		response.flushBuffer();
		
	}
	
}
