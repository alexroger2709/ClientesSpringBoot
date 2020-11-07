package br.com.clientes.representation;

import javax.persistence.Column;
import javax.persistence.Id;

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
	private String idCliente;
	
	
	@JsonProperty(value = "descricao")
	private String descricao;
	
	
	@Column(name="valor")
	private String valor;
	
	
	@JsonProperty(value = "data")
	private String data;	
	
}
