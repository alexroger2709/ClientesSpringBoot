package br.com.clientes.exception;

public class UsuarioCadastroException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioCadastroException(String login) {
		super("Usuário já cadastrado para o login " + login);
	}
	
}
