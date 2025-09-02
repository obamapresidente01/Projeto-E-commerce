-- DQL - CONSULTA
SELECT nome_completo, telefone FROM ecommerce.cliente;

SELECT nome, idade FROM clinica.paciente;

SELECT * FROM clinica.medico;

-- JOIN (Juntar)
-- Com o JOIN posso juntar tabelas
-- Utilizando a Chave Estrangeira

-- LIstar, Data, Valor, Nome Medico

SELECT data, valor, nome FROM clinica.consulta /*AS cs (cs.data, cs.valor...)*/
JOIN clinica.medico ON clinica.consulta.id_consulta /*AS med (cs.id_medico = meu.id_medico)*/ /* (id_medico) */ = clinica.medico.id_medico 