package br.com.clientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.clientes.data.model.Cliente;
import br.com.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;
	
	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}


	public Cliente salvar(Cliente cliente) {
		Cliente ret = null;
		ret = repository.save(cliente);
		return ret;
	}
	
	
	public Cliente localizarPorId(Integer clienteId) {
		Cliente ret = null;
		ret = repository
				.findById(clienteId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
		return ret;
	}
	

	public List<Cliente> localizarTodos(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = repository.findAll();
		return clientes;
	}
	
	
	public Cliente atualizar(Cliente cliente) {
		Cliente entity = localizarPorId(cliente.getId());

		entity.setNome(cliente.getNome());
		entity.setCpf(cliente.getCpf());
		entity = repository.save(entity);
		
		return entity;
	}

	
	public ResponseEntity<?> delete(Integer clienteId) {
		Cliente cliente = localizarPorId(clienteId);
		repository.delete(cliente);
		return ResponseEntity.ok().build();
	}	
}
