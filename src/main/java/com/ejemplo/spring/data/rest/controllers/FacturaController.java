package com.ejemplo.spring.data.rest.controllers;

import java.net.URISyntaxException;
import java.util.Iterator;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.services.Servicio;

@RestController
@RequestMapping("/Facturas")
public class FacturaController {
	
	@Autowired
	private Servicio servicio;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Factura consultar(@PathVariable long id) {
		return servicio.buscarPorId(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterator<Factura> consultar(
									@RequestParam(name="page", defaultValue="0") int pagina, 
									@RequestParam(name="num", defaultValue="10") int numeroElementos) {
		return servicio.buscar(pagina, numeroElementos).iterator();
	}
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertar(@RequestBody Factura factura) throws URISyntaxException{
		Factura factura2 = servicio.nuevo(factura);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(factura2.getId()).toUri());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(DataIntegrityViolationException e) {
        return new ErrorResponse(e.getMessage()); // use message from the original exception
    }
	
	@PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public void modificar(@RequestBody Factura factura) throws Exception{
		throw new Exception("no implementado");
	}
	
	@DeleteMapping(path="/{id}")
	public void borrar(@PathVariable long id) throws Exception {
		throw new Exception("no implementado");
	}
	
}
