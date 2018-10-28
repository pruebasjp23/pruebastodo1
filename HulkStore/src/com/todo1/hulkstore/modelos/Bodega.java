package com.todo1.hulkstore.modelos;

public class Bodega {

	private long codigo;
	private String bodega;
	
	public Bodega() {}
	public Bodega(long codigo) {
		this.codigo = codigo;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	
}
