package com.todo1.hulkstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.todo1.hulkstore.modelos.Bodega;
import com.todo1.hulkstore.servicios.Inicio;
import com.todo1.hulkstore.utils.Constantes;

public class BodegaDao {

	public void guardarBodega(Bodega bodega) {
		
		HttpSession sesion = Inicio.sesion;
		
		List<Bodega> listaBodegas = new ArrayList<>();
		
		if(sesion.getAttribute(Constantes.BODEGAS) == null) {
			System.out.println("esta vacia");
			sesion.setAttribute(Constantes.BODEGAS, listaBodegas);
		}
		
		listaBodegas = (List<Bodega>)sesion.getAttribute(Constantes.BODEGAS);
		
		if(listaBodegas.isEmpty())
			bodega.setCodigo(1);
		else
			bodega.setCodigo(listaBodegas.size()+1);
		
		listaBodegas.add(bodega);
		
		sesion.removeAttribute(Constantes.BODEGAS);
		
		sesion.setAttribute(Constantes.BODEGAS, listaBodegas);
	}
	
	public Bodega consultarBodegaPorCodigo(long idBodega) {
		HttpSession sesion = Inicio.sesion;
		Bodega bodega = new Bodega();
		
		if(sesion.getAttribute(Constantes.BODEGAS) == null) {
			System.out.println("no existen bodegas");
		}else {
			List<Bodega> listaBodegas = (List<Bodega>)sesion.getAttribute(Constantes.BODEGAS);
			
			for(Bodega b : listaBodegas) {
				if(b.getCodigo() == idBodega) {
					System.out.println(b.getCodigo());
					System.out.println(b.getBodega());
					
					bodega = b;
					
					break;
				}
			}
		}
		
		return bodega;
	}
}
