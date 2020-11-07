package br.com.clientes.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="servicos")
public class ServicoPrestado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonProperty(value = "idCliente")
	private Cliente cliente;
	
	
	@Column(name = "descricao", nullable = false, length = 150)
	@JsonProperty(value = "descricao")
	private String descricao;
	
	
	@Column(name="valor")
	@JsonProperty(value = "valor")
	private BigDecimal valor;
	
	
	@Column(name="data")
	@JsonProperty(value = "data")
	private LocalDate data;
}
