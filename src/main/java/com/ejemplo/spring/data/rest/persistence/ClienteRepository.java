package com.ejemplo.spring.data.rest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.spring.data.rest.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
