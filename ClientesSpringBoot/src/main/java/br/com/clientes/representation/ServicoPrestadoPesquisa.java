package br.com.clientes.representation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class ServicoPrestadoPesquisa {

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;


	@Column(name="id_cliente")
	private String idCliente;
	

	@Column(name="descricao")
	private String descricao;
	
	
	@Column(name="valor")
	private String valor;
	
	
	@Column(name="data")
	private String data;	
	
}
