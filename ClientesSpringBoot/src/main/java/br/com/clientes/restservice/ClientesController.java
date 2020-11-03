package br.com.clientes.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.data.model.Cliente;
import br.com.clientes.service.ClienteService;


@RestController
@RequestMapping(value="/api/clientes/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientesController {

	private final ClienteService service;
	
	@Autowired
	public ClientesController(ClienteService service) {
		this.service = service;
	}


	//Hello World
	@GetMapping(
			value="/hello",
			produces={"application/json","application/xml"}
		)
	public String HelloWorld() {
		String ret;
		ret = "Hello World :) ";
		return ret;
	}

	
	
	//Add cliente
	@PostMapping(
			value = "/salvar",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"}
			)
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody @Valid Cliente cliente) throws Exception {
		Cliente ret = new Cliente();
		ret = service.salvar(cliente);
		return ret;
	}

	
	
	//@ApiOperation(value="Find all people recorded")
	@GetMapping(value = "/{id}",
			produces = {"application/json","application/xml"}
			)
	public Cliente findById(@PathVariable(value="id") String id) throws Exception {
		Cliente cliente = new Cliente();
		cliente = service.localizarPorId(Integer.valueOf(id));
		return cliente;
	}
	
	
	
	@GetMapping(
			produces = {"application/json","application/xml"}
			)
	public List<Cliente> findAll() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = service.localizarTodos();
		return clientes;
	}
	
	
	@PutMapping(
			value = "/atualizar",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public Cliente update(@RequestBody @Valid Cliente cliente) throws Exception {
		Cliente ret = new Cliente();
		ret = service.atualizar(cliente);
		return ret;
	}


	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/excluir/{id}")
	public void delete(@PathVariable(value="id") String id) throws Exception {
		service.delete(Integer.valueOf(id));
	}
}
