package br.com.clientes.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.representation.ServicoPrestadoRequest;
import br.com.clientes.representation.ServicoPrestadoResponse;
import br.com.clientes.service.ServicoPrestadoService;

@RestController
@RequestMapping(value="/api/servicos-prestados/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoPrestadoController {
	
	private final ServicoPrestadoService service;
	
	@Autowired
	public ServicoPrestadoController(ServicoPrestadoService service) {
		this.service = service;
	}
	

	@PostMapping(
			value = "/salvar",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"}
			)
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestadoResponse create(@RequestBody ServicoPrestadoRequest servicoPrestado) throws Exception {
		ServicoPrestadoResponse ret = new ServicoPrestadoResponse();
		ret = service.salvar(servicoPrestado);
		return ret;
	}
}
