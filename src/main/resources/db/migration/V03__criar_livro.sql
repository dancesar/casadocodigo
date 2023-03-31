create table livro(
    id serial primary key,
    titulo varchar(255) NOT NULL,
    resumo varchar(500) NOT NULL,
    sumario varchar(255) NOT NULL,
    preco numeric(12,2) NOT NULL,
    numPaginas int NOT NULL,
    isbn varchar(17) NOT NULL,
    dataPublicacao timestamp,
    idCategoria int NOT NULL,
    idAutor int NOT NULL,

    foreign key (idAutor) references autor (id),
    foreign key (idCategoria) references categoria (id)
);