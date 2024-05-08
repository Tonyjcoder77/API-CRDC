INSERT INTO USUARIO(nome, email, senha) VALUES('FrontUser', 'frontUser@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO
EMPRESA(razao, identificador)
VALUES('google', '1234567890');

INSERT INTO
TRANSACAO(tipo, valor, conta_origem, conta_destino, empresa_id)
VALUES('C', 100.00, 777, 888, 1);

INSERT INTO
TRANSACAO(tipo, valor, conta_origem, conta_destino, empresa_id)
VALUES('C', 200.00, 777, 888, 1);

INSERT INTO
TRANSACAO(tipo, valor, conta_origem, conta_destino, empresa_id)
VALUES('D', 10.00, 777, 888, 1);

INSERT INTO
TRANSACAO(tipo, valor, conta_origem, conta_destino, empresa_id)
VALUES('C', 300.00, 777, 888, 1);


