package com.ejemplo.spring.data.rest.services;

import org.springframework.data.domain.PageRequest;

import com.ejemplo.spring.data.rest.entities.Factura;

public interface Servicio {

	Factura nuevo(Factura factura);

	Iterable<Factura> buscar();

	Iterable<Factura> buscarPorConcepto(String concepto);

	Factura buscarPorId(Long id);

	Iterable<Factura> buscar(int pagina, int numElementos);
	
}