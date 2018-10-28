package com.todo1.hulkstore.servicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Inicio extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6510045205672664032L;
	
	public static HttpSession sesion;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		System.out.println("esta siendo llamad o en el get");
		sesion = request.getSession();
		sesion.setAttribute("INICIO", "ESTA INICIALIZADA LA VARIABLE DE SESSION. SE PUEDE GUARDAR LOS OBJETOS.");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException
		  {
		System.out.println("en el post post");
		
		  }
}
