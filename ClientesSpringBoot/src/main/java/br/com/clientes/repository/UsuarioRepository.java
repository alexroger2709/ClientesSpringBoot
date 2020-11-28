package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.data.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
