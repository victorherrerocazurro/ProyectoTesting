package com.ejemplo.spring.data.rest.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ejemplo.spring.data.rest.entities.Factura;

@RestResource(exported= false, path="/fact")
public interface FacturaRepository extends JpaRepository<Factura, Long>{

	@RestResource(exported=false)
	List<Factura> findByConcepto(String concepto);
	
	@Query(value="select f from Factura f where f.concepto = :concepto")
	List<Factura> consultarPorConcepto(@Param("concepto") String concepto);
	
	Page<Factura> findByConceptoStartsWith(@Param("concepto") String concepto, Pageable p);
	
}
