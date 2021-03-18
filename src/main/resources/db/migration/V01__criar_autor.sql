create table autor(
    id serial primary key,
    nome varchar(100) NOT NULL,
    email varchar(150) NOT NULL,
    descricao varchar(400) NOT NULL,
    dt_cadastro timestamp
);