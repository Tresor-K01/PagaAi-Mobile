CREATE TABLE usuario (
                         id INT PRIMARY KEY NOT NULL,
                         nome VARCHAR(250) NOT NULL,
                         email VARCHAR(250) NOT NULL,
                         senha VARCHAR(100) NOT NULL,
                         telefone VARCHAR(50) NOT NULL
);

CREATE TABLE morador (
                         id INT PRIMARY KEY REFERENCES usuario(id) ON DELETE CASCADE,
                         numero_do_quarto VARCHAR(10)
);

CREATE TABLE despesas (
                          id INT PRIMARY KEY NOT NULL,
                        nome VARCHAR,
                          tipo VARCHAR(20),
                          data DATE NOT NULL,
                          valor NUMERIC(10, 2) NOT NULL
);

CREATE TABLE obrigacoes (
                            id INT PRIMARY KEY NOT NULL,
                            despesas_id INT REFERENCES despesas(id) ON DELETE CASCADE,
                            dat_obrigacao DATE NOT NULL,
                            data_vencimento DATE NOT NULL,
                            valor_devido NUMERIC(10, 2) NOT NULL
);

CREATE TABLE pagamento (
                           id INT PRIMARY KEY NOT NULL,
                           id_usuario INT REFERENCES usuario(id) ON DELETE CASCADE,
                           id_morador INT REFERENCES morador(id) ON DELETE CASCADE,
                           valor NUMERIC(10, 2),
                           data_pagamento DATE NOT NULL
);