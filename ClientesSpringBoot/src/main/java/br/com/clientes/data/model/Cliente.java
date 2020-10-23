package br.com.clientes.data.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="clientes")
public class Cliente {
	
	//class members
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	private Integer id;

	@JsonProperty(value = "nome")
	@Column(name="nome", nullable = false, length = 150)
	@NotEmpty(message="{campo.nome.obrigatorio}")
	private String nome;
	
	@JsonProperty(value = "cpf")
	@Column(name="cpf", nullable = false, length = 11)
	@NotNull(message="{campo.cpf.obrigatorio}")
	@CPF(message="{campo.cpf.invalido}")
	private String cpf;
	

	@JsonProperty(value = "dataCadastro")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		if (getDataCadastro() == null) {
			setDataCadastro(LocalDate.now());
		}
	}
}
