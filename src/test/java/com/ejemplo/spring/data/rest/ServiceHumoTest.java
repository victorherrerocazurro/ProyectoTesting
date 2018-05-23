package com.ejemplo.spring.data.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
//Permite definir un datasource distinto al original
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ServiceHumoTest {
	
	@Autowired
	MockMvc mock;
	
	@Test
	public void consultarPorIdTest() throws Exception {
		mock.perform(get("/Facturas/0")).andExpect(status().is(200));
	}
	
	@Test
	public void nuevoTest() throws Exception {
		Factura factura = new Factura(4, "Compra Monitor");
		
		ObjectMapper mapper = new ObjectMapper();
	    byte[] facturaAsBytes = mapper.writeValueAsBytes(factura);

		mock
			.perform(post("/Facturas").content(facturaAsBytes).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is(201));
	}
	
	


}
