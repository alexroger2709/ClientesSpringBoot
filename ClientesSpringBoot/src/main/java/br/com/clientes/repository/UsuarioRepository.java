package br.com.clientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clientes.data.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
	@Query(value = "select u.id, u.login, u.senha from\n"
			+ " usuarios u where lower(u.login) = lower(:login)", nativeQuery = true)
	public Optional<Usuario> localizarUsuarioPorLogin(
				@Param("login") String login
			);
	
}
