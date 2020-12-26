package br.com.clientes.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.configuration.TesteComponent;

@RestController
@RequestMapping(value="/api/teste/v1")
public class TesteController {
	

	@Autowired
	TesteComponent testeComponent;

	@GetMapping(
			value="/aplicacao",
			produces={"application/json","application/xml"}
		)
	public String exibirNomeAplicacao() {
		String ret;
		ret = testeComponent.getNomeAplicacao();
		return ret;
	}

	
	@GetMapping(
			value="/aplicacao2",
			produces={"application/json","application/xml"}
		)
	public String exibirNomeAplicacaoModificado() {
		String ret;
		testeComponent.setNomeAplicacao("Hello World!!!!!!!!!! :)");
		ret = testeComponent.getNomeAplicacao();
		return ret;
	}
	
}
