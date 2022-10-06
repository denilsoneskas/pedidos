CREATE TABLE  IF NOT EXISTS produto
(
	id serial PRIMARY KEY,
	nome varchar(32) NOT NULL,
	descricao varchar(255) NOT NULL,
	preco decimal NOT NULL,
	fabricacao date NOT NULL,
	validade integer NOT NULL,
	promocao_id integer,
	FOREIGN KEY (promocao_id)
    		REFERENCES promocao(id)
    		ON UPDATE CASCADE
);