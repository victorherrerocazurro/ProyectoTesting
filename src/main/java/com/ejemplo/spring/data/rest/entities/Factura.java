package com.ejemplo.spring.data.rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Factura {

	@Id
	private long id;//PK
	private String concepto;
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Factura(long id, String concepto) {
		super();
		this.id = id;
		this.concepto = concepto;
	}
	public Factura() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", concepto=" + concepto + "]";
	}
}
