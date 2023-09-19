create table conserto(
    id bigint not null auto_increment,
    datadeentrada varchar(100) not null,
    datadesaida varchar(100) not null,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano varchar(100) not null,
    nome varchar(100) not null,
    anosxp varchar(100) not null,
    primary key(id)
);