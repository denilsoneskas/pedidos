CREATE TABLE  IF NOT EXISTS pedido
(
	id serial PRIMARY KEY,
	data date NOT NULL,
	entrega integer NOT NULL,
	total double precision NOT NULL,
	pagamento varchar(2) NOT NULL,
	pago boolean default false,
	cancelado boolean default false,
	produto_id integer,
	FOREIGN KEY (produto_id)
    		REFERENCES produto(id)
    		ON UPDATE CASCADE,
	pessoa_id integer,
	FOREIGN KEY (pessoa_id)
    		REFERENCES pessoa(id)
    		ON UPDATE CASCADE
);