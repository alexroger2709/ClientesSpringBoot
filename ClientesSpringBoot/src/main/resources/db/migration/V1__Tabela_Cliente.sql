CREATE TABLE clientes(
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
    data_cadastro DATE,
    CONSTRAINT pk_clientes_id PRIMARY KEY (id)
);