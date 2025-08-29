-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL
-- SET search path TO clinica;
-- clinica.paciente -> paciente

-- INSERT INTO <SCHEMA>, <TABELA>, (<COLUNAS>) VALUES
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('Vinicio', 'Ortopedista', '123456'),
('Ariel', 'Cardiologia', '654321')

INSERT INTO clinica.paciente(nome, idade) VALUES
('Fulano', 23),
('Luiz', 18);

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('Clinica Sao Caetano', 'A clinica do ABC', 'Rua Niteroi, 26');

INSERT INTO clinica.consulta(data, valor, id_clinica, id_paciente) VALUES
('2025-08-28 09:30:00-03', 350.75, 1, 1)

-- DQL(Data Query Language) - Linguagem de Consulta
-- de Dados
-- SELECT
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>,<TABELA>
SELECT * FROM clinica.medico;
SELECT * FROM clinica.paciente;
SELECT * FROM clinica.clinica;
SELECT * FROM clinica.consulta;

-- UPDATE
UPDATE clinica.consulta
SET valor = 200.50
WHERE id_consulta = 1;

/*
WHERE valor > 500 AND valor < 1000;
                  OR
				  
*/

-- DELETE
DELETE FROM clinica.medico
WHERE FROM = 'Vinicio';

/*
WHERE FROM = id_medico =1;
*/