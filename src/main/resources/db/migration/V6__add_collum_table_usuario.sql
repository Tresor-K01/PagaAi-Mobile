ALTER TABLE usuario ADD COLUMN status_usuario VARCHAR(30) CHECK
    ( status_usuario IN ( 'ROLE_ADMIN','ROLE_MORADOR'));