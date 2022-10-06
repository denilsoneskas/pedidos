CREATE TABLE  IF NOT EXISTS cidade
(
	id serial PRIMARY KEY,
	nome varchar(64) NOT NULL,
	estado varchar(64) NOT NULL
);