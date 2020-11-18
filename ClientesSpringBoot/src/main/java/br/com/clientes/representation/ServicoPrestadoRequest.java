package br.com.clientes.representation;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ServicoPrestadoRequest {

	@Id
	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "idCliente")
	@NotEmpty(message="{campo.cliente.obrigatorio}")
	private String idCliente;
	

	@JsonProperty(value = "descricao")
	@NotEmpty(message="{campo.descricao.obrigatorio}")
	private String descricao;

	
	@JsonProperty(value = "valor")
	@NotEmpty(message="{campo.valor.obrigatorio}")
	private String valor;
	

	@JsonProperty(value = "data")
	@NotEmpty(message="{campo.data.obrigatorio}")
	private String data;	
	
}
