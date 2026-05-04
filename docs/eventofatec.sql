CREATE DATABASE Evento
GO
USE Evento

CREATE TABLE historico (
id INT IDENTITY(1,1),
curiosidade_id INT,
data_exibicao DATETIME
PRIMARY KEY(id)
);
GO
CREATE TABLE curso (
id INT NOT NULL,
nome VARCHAR(50) NOT NULL
PRIMARY KEY(id)
)
GO
-- Tabela Videogame
CREATE TABLE videogame (
id INT IDENTITY(1,1),
nome VARCHAR(100) NOT NULL
PRIMARY KEY(id)
)
GO
-- Tabela Mensagem
CREATE TABLE mensagem (
id INT ,
conteudo VARCHAR(256) NOT NULL,
tipo VARCHAR(30) NOT NULL
PRIMARY KEY(id)
)
GO
-- Tabela Candidato
CREATE TABLE candidato (
id INT IDENTITY(1,1),
nome VARCHAR(100) NOT NULL,
email VARCHAR(75) NOT NULL,
celular VARCHAR(11) NOT NULL,
bairro VARCHAR(50) NOT NULL,
dataCad DATETIME2 NOT NULL,
curso_id INT NULL,
aceitacao BIT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (curso_id) REFERENCES curso(id)
)
GO
-- Tabela Curiosidade
CREATE TABLE curiosidade (
id INT IDENTITY(1,1) NOT NULL,
conteudo VARCHAR(256) NOT NULL,
videogame_id INT NULL
PRIMARY KEY(id),
FOREIGN KEY (videogame_id) REFERENCES videogame(id)
)
GO
CREATE TRIGGER trg_CandidatoUpdate
ON candidato
AFTER UPDATE
AS
BEGIN
    RAISERROR('Candidato não pode ser alterado', 16, 1);
	ROLLBACK
END
GO

CREATE TRIGGER trg_CandidatoDelete
ON candidato
AFTER DELETE
AS
BEGIN
    RAISERROR('Candidato não pode ser excluído', 16, 1);
	ROLLBACK
END
GO

CREATE OR ALTER TRIGGER trg_CandidatoInsert
ON candidato
AFTER INSERT
AS
BEGIN
    IF (SELECT COUNT(*) FROM inserted WHERE nome IS NULL
        OR nome LIKE '%[^A-Za-zÀ-ÿ ]%'
        OR LEN(LTRIM(RTRIM(nome))) < 3
        OR nome NOT LIKE '% %') > 0
    BEGIN
        ;THROW 50000, 'Nome inválido', 1;
    END

    IF (SELECT COUNT(*) FROM inserted WHERE email IS NULL
        OR email LIKE '% %'
        OR email NOT LIKE '%_@_%._%'
        OR LEN(LTRIM(RTRIM(email))) < 3
        OR email LIKE '%@%@%') > 0
    BEGIN
        ;THROW 50000, 'Email inválido', 1;
    END

    IF (SELECT COUNT(*) FROM inserted i
        INNER JOIN candidato c ON c.email = i.email
        AND c.id <> i.id) > 0
    BEGIN
        ;THROW 50000, 'Email já cadastrado', 1;
    END

    IF (SELECT COUNT(*) FROM inserted WHERE celular IS NULL
        OR LEN(celular) < 10
        OR LEN(celular) > 11
        OR celular LIKE '%[^0-9]%') > 0
    BEGIN
        ;THROW 50000, 'Celular inválido', 1;
    END

    IF (SELECT COUNT(*) FROM inserted i
        INNER JOIN candidato c ON c.celular = i.celular
        AND c.id <> i.id) > 0
    BEGIN
        ;THROW 50000, 'Celular já cadastrado', 1;
    END

    IF (SELECT COUNT(*) FROM inserted WHERE bairro IS NULL
        OR LEN(LTRIM(RTRIM(bairro))) = 0 OR LEN(bairro) < 4) > 0
    BEGIN
        ;THROW 50000, 'Bairro inválido', 1;
    END

END
GO

CREATE TRIGGER trg_CuriosidadeUpdate
ON curiosidade
AFTER UPDATE
AS
BEGIN
    ;THROW 50000, 'Curiosidade não pode ser alterada', 1;
END;	
GO

CREATE TRIGGER trg_CuriosidadeDelete
ON curiosidade
AFTER Delete
AS
BEGIN
    RAISERROR('Curiosidade não pode ser excluída', 16, 1)
	ROLLBACK
END

GO
CREATE FUNCTION fn_curiosidade_valida ( 
	@curiosidade_id INT,
    @videogame_id INT
)
RETURNS BIT
AS
BEGIN
    DECLARE @valido BIT = 1;

    IF EXISTS (
        SELECT 1
        FROM (
            SELECT TOP 3 h.curiosidade_id
            FROM historico h
            INNER JOIN curiosidade c ON h.curiosidade_id = c.id
            WHERE c.videogame_id = @videogame_id
            ORDER BY h.data_exibicao DESC
        ) ultimos
        WHERE ultimos.curiosidade_id = @curiosidade_id 
    )
        SET @valido = 0

    RETURN @valido
END
GO
CREATE PROCEDURE sp_ObterCuriosidadeAleatoria
    @videogame_id INT,
	@texto VARCHAR(256) OUTPUT
AS
BEGIN
    DECLARE @id INT
    SELECT TOP 1 @id = c.id, @texto = c.conteudo
    FROM curiosidade c
    WHERE c.videogame_id = @videogame_id
      AND dbo.fn_curiosidade_valida(c.id, @videogame_id) = 1
    ORDER BY NEWID();

    INSERT INTO historico (curiosidade_id, data_exibicao)
    VALUES (@id, GETDATE());

    DELETE FROM historico
    WHERE id NOT IN (
        SELECT TOP 3 h.id
        FROM historico h
        INNER JOIN curiosidade c ON h.curiosidade_id = c.id
        WHERE c.videogame_id = @videogame_id
        ORDER BY h.data_exibicao DESC
    )
    AND curiosidade_id IN (
        SELECT id FROM curiosidade WHERE videogame_id = @videogame_id
    )
END

GO

CREATE PROCEDURE sp_ValidarLogin
    @login VARCHAR(50),
    @senha VARCHAR(100)
AS
BEGIN
    IF (@login = 'admin' AND @senha = 'RAj@lfO%')
        SELECT 1 AS resultado
    ELSE
        SELECT 0 AS resultado
END;
GO

INSERT INTO CURSO VALUES (1, 'Análise e Desenvolvimento de Sistemas')
INSERT INTO CURSO VALUES (2, 'Comércio Exterior')
INSERT INTO CURSO VALUES (3, 'Polímeros')
INSERT INTO CURSO VALUES (4, 'Gestão de Recursos Humanos')
INSERT INTO CURSO VALUES (5, 'Gestão Empresarial')
INSERT INTO CURSO VALUES (6, 'Logística')
INSERT INTO CURSO VALUES (7, 'Desenvolvimento de Produtos Plásticos	')

SELECT * FROM HISTORICO
SELECT * FROM CURIOSIDADE
SELECT * FROM CURSO
SELECT * FROM CANDIDATO

DROP TABLE CANDIDATO
SELECT * FROM CURSO

SELECT * FROM MENSAGEM

SELECT * FROM curiosidade
SELECT * FROM HISTORICO

