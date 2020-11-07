package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.data.model.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

}
