CREATE TABLE novasenha (
    id integer not null generated always  as identity primary key,
    nova_senha VARCHAR,
    usuario_id integer REFERENCES usuario(id) ON DELETE CASCADE ,
    reset_Token_Expiration TIMESTAMP NOT NULL
);