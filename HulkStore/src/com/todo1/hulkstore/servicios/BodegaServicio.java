package com.todo1.hulkstore.servicios;

import com.todo1.hulkstore.dao.BodegaDao;
import com.todo1.hulkstore.modelos.Bodega;

public class BodegaServicio {
	
	public void guardarBodega(String data) {
		
		System.out.println(data);
		//[BODEGA PRINCIPAL]
		data = data.replace("[", "");
		data = data.replace("]", "");
		
		String datos[] = data.split(";");
		
		Bodega bodega = new Bodega();
		
		bodega.setBodega(datos[0]);
		
		BodegaDao dao = new BodegaDao();
		dao.guardarBodega(bodega);
	}

}
