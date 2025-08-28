CREATE SCHEMA ecommerce;

CREATE TABLE ecommerce.cliente (
	cliente_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_completo TEXT NOT NULL,
	email TEXT NOT NULL,
	telefone TEXT NOT NULL,
	data_cadastro TIMESTAMPTZ NOT NULL
);

CREATE TABLE ecommerce.pedido (
	pedido_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	valor_total NUMERIC (10, 4),
	status TEXT NOT NULL,
	cliente_id INT NOT NULL,
	FOREIGN KEY (cliente_id) REFERENCES ecommerce.cliente(cliente_id)
);

CREATE TABLE ecommerce.itempedido (
	item_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	cliente_id INT NOT NULL REFERENCES ecommerce.cliente (cliente_id),
	produto_id INT NOT NULL REFERENCES ecommerce.pedido (pedido_id),
	quantidade INT
);