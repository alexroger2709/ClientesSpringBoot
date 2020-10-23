CREATE TABLE servicos(
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
	descricao VARCHAR(150) NOT NULL,
    valor DECIMAL(13,2),
    CONSTRAINT pk_servicos_id PRIMARY KEY (id, id_cliente),
    CONSTRAINT fk_servicos_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);