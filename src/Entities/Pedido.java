package Entities;


import java.util.*;

public class Pedido {
	private int idPedido;
	private String estado;
	private Date fechaPedido;
	private Date fechaCancelacion;
	private Usuario usu;
	private Double monto;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Usuario getUsu() {
		return usu;
	}
	public void setUsu(Usuario usu) {
		this.usu = usu;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date date) {
		this.fechaPedido = date;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", estado=" + estado + ", fechaPedido=" + fechaPedido
				+ ", fechaCancelacion=" + fechaCancelacion + "]";
	}
	
	
	
}
