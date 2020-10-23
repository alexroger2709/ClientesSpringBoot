package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.data.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
