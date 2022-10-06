CREATE TABLE  IF NOT EXISTS pessoa
(
	id serial PRIMARY KEY,
	nome varchar(32) NOT NULL,
	telefone varchar(32) NOT NULL,
	dataNascimento date NOT NULL,
	vendedor boolean default false,
	endereco_id integer,
	FOREIGN KEY (endereco_id)
    		REFERENCES endereco(id)
    		ON UPDATE CASCADE
);