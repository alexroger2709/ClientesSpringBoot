package br.com.clientes.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.representation.ServicoPrestadoPesquisa;
import br.com.clientes.representation.ServicoPrestadoRequest;
import br.com.clientes.representation.ServicoPrestadoResponse;
import br.com.clientes.service.ServicoPrestadoService;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api/servicos-prestados/v1")
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
	public ServicoPrestadoResponse create(@RequestBody @Valid ServicoPrestadoRequest servicoPrestado) throws Exception {
		ServicoPrestadoResponse ret = new ServicoPrestadoResponse();
		ret = service.salvar(servicoPrestado);
		return ret;
	}
	
	

	@GetMapping(value = "/pesquisar",
			produces = {"application/json","application/xml"}
			)
	public List<ServicoPrestadoPesquisa> pesquisar(
			@RequestParam(name="nome", required=false, defaultValue="") String nome,
			@RequestParam(name="mes", required=false) Integer mes
			) throws Exception {
		List<ServicoPrestadoPesquisa> ret = new ArrayList<>();
		ret = service.pesquisar("%" + nome + "%", mes);
		return ret;
	}

}
