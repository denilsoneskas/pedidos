CREATE TABLE  IF NOT EXISTS endereco
(
	id serial PRIMARY KEY,
	rua varchar(64) NOT NULL,
	numero integer NOT NULL,
	bairro integer NOT NULL,
	cep varchar(20) NOT NULL,
	complemento varchar(64),
	referencia varchar(64),
	cidade_id integer,
	FOREIGN KEY (cidade_id)
    		REFERENCES cidade(id)
    		ON UPDATE CASCADE
);