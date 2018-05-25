package com.ejemplo.spring.data.rest;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.persistence.FacturaRepository;
import com.ejemplo.spring.data.rest.services.Servicio;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Import(ConfiguracionTest.class)
public class ServiceUT {

	@Autowired
	Servicio sut;
	
	@MockBean
	FacturaRepository repository;
	
	//Datos de Prueba (Ctes)
	Factura facturaSinId = new Factura(0, "Compra");
	Factura facturaConId = new Factura(1, "Compra");
	
	@Before
	public void init(){
		Mockito.when(repository.save(facturaSinId)).thenReturn(facturaConId);
	}
	
	@Test
	public void nuevoTest() {

		//Ejecutar el codigo a probar
		Factura resultadoObtenido = sut.nuevo(facturaSinId);
		//resuladoObtenido es unicamente dependiente de nuestro algoritmo
		
		//Validar
		assertEquals(facturaConId.getId(), resultadoObtenido.getId());
		
	}
	
	@Test
	public void testConProblema() {
		assertTrue(true);
	}

}
