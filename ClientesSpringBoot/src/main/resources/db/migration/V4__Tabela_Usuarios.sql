CREATE TABLE IF NOT EXISTS usuarios(
	id int not null auto_increment,
    login varchar(200) not null unique,
    senha varchar(200) not null,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);