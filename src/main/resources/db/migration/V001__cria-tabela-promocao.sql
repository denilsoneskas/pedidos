CREATE TABLE  IF NOT EXISTS promocao
(
	id serial PRIMARY KEY,
	nome varchar(32) NOT NULL,
	descricao varchar(255) NOT NULL,
	desconto integer NOT NULL,
	inicio date NOT NULL,
	fim date NOT NULL
);