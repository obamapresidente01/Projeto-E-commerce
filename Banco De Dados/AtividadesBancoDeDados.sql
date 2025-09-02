-- FUNDAMENTAIS
-- ATIVIDADE 1
SELECT nome_completo, email FROM ecommerce.cliente;
-- ATIVIDADE 2
SELECT * FROM ecommerce.itempedido
WHERE preco > 1000;

-- INTERMEDIARIOS
--ATIVIDADE 1
SELECT pedido_id, nome_completo FROM ecommerce.pedido
JOIN ecommerce.cliente ON ecommerce.pedido.cliente_id = ecommerce.cliente.cliente_id
