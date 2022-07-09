
/*se o banco não for criando com o kubernets
entrar no banco com o acesso root e criar*/

create database

create table infos_propriedade(
      id_propriedade int primary key not null,
      nome_propriedade varchar(200)
);

create table laboratorio(
    id_laboratorio int primary key not null,
    nome_laboratorio varchar(200)
);

create table fazenda(
    id_fazenda int primary key auto_increment null,
    data_inicial datetime,
    data_final datetime,
    id_propriedade_fazenda int NOT NULL,
    FOREIGN KEY (id_propriedade_fazenda) REFERENCES infos_propriedade(id_propriedade),
    cnpj varchar(14) not null,
    id_laboratorio int NOT NULL,
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorio(id_laboratorio),
    observacoes varchar(1000)
);