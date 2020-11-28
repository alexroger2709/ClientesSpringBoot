package br.com.clientes.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.data.model.Usuario;
import br.com.clientes.service.UsuarioService;

@RestController
@RequestMapping(value="/api/usuarios/v1")
public class UsuariosController {

	private final UsuarioService service;
	
	public UsuariosController(UsuarioService service) {
		this.service = service;
	}

	
	
	
	@PostMapping(
			value = "/salvar",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"}
			)
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody @Valid Usuario usuario) throws Exception {
		Usuario ret = new Usuario();
		ret = service.salvar(usuario);
		return ret;
	}

	
	
	//@ApiOperation(value="Find all people recorded")
	@GetMapping(value = "/{id}",
			produces = {"application/json","application/xml"}
			)
	public Usuario findById(@PathVariable(value="id") String id) throws Exception {
		Usuario usuario = new Usuario();
		usuario = service.localizarPorId(Integer.valueOf(id));
		return usuario;
	}

	
	
	@GetMapping(
			produces = {"application/json","application/xml"}
			)
	public List<Usuario> findAll() throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = service.localizarTodos();
		return usuarios;
	}

	
	
	@PutMapping(
			value = "/atualizar",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public Usuario update(@RequestBody @Valid Usuario usuario) throws Exception {
		Usuario ret = new Usuario();
		ret = service.atualizar(usuario);
		return ret;
	}


	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/excluir/{id}")
	public void delete(@PathVariable(value="id") String id) throws Exception {
		service.delete(Integer.valueOf(id));
	}
	
	
}
