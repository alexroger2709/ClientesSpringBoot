package br.com.clientes.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")	
	private Integer id;
	
	@JsonProperty(value = "login")
	@Column(name="login", nullable = false, unique = true, length = 200)
	@NotEmpty(message="{campo.login.obrigatorio}")
	private String username;
	
	@JsonProperty(value = "senha")
	@Column(name="senha", nullable = false, length = 200)
	@NotEmpty(message="{campo.senha.obrigatorio}")
	private String password;
	
}
