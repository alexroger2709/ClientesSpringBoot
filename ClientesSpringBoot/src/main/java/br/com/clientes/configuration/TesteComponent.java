package br.com.clientes.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Component
public class TesteComponent {

	
	@Value("${teste.nome.aplicacao}")
	private String nomeAplicacao;
	
}
