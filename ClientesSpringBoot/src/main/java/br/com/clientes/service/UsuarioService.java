package br.com.clientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.clientes.data.model.Usuario;
import br.com.clientes.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	private final UsuarioRepository repository;
	
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	
	public Usuario salvar(Usuario usuario) {
		Usuario ret = null;
		ret = repository.save(usuario);
		return ret;
	}
	
	
	public Usuario localizarPorId(Integer usuarioId) {
		Usuario ret = null;
		ret = repository
				.findById(usuarioId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
		return ret;
	}
	
	

	public List<Usuario> localizarTodos(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = repository.findAll();
		return usuarios;
	}
	

	
	public Usuario atualizar(Usuario usuario) {
		Usuario entity = localizarPorId(usuario.getId());

		entity.setUsername(usuario.getUsername());
		entity.setPassword(usuario.getPassword());
		entity = repository.save(entity);
		
		return entity;
	}

	
	public ResponseEntity<?> delete(Integer usuarioId) {
		Usuario usuario = localizarPorId(usuarioId);
		repository.delete(usuario);
		return ResponseEntity.ok().build();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario ret = new Usuario();
		
		ret = repository
				.localizarUsuarioPorLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
		
		return User
			.builder()
			.username(ret.getUsername())
			.password(ret.getPassword())
			.roles("USER")
			.build();
	}	
	
}
