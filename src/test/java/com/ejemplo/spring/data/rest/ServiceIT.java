package com.ejemplo.spring.data.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.services.Servicio;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Import(ConfiguracionTest.class)
@EnableJpaRepositories
public class ServiceIT {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	Servicio sut;
	
	//Datos de Prueba (Ctes)
	Factura factura = new Factura(7, "Compra");
	
	@Test
	public void nuevoTest() {

		//Ejecutar el codigo a probar
		//Factura resultadoObtenido = sut.nuevo(factura);
		sut.nuevo(factura);
		//resuladoObtenido es unicamente dependiente de nuestro algoritmo
		
		//En caso de que el SUT probado no retorne resultado, la alternativa para la validacion
		//es comprobar el estado en el que queda el entorno
		Factura resultadoObtenido = entityManager.find(Factura.class, 7l);
		
		//Validar
		assertEquals(factura.getId(), resultadoObtenido.getId());
		
		
		
	}

}
