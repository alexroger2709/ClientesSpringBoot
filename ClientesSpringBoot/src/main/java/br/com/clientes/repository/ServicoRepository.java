package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.data.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
