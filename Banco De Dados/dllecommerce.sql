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

CREATE TABLE ecommerce.pagamento (
	pagamento_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	pedido_id INT NOT NULL, FOREIGN KEY (pedido_id) REFERENCES ecommerce.pedido(pedido_id),
	forma_pagamento TEXT NOT NULL,
	status TEXT NOT NULL,
	data_pagamento TIMESTAMPTZ
);

CREATE TABLE produto (
	produto_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_produto TEXT,
	descricao TEXT,
	preco NUMERIC(10, 4),
	estoque_disponivel INT,
	imagem_url TEXT NOT NULL
);