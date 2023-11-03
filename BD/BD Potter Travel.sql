create database agencia_viagem;

use agencia_viagem;

create table Cliente(
id int not null auto_increment primary key,
nome varchar(255),
cpf varchar(40),
telefone varchar(40),
email varchar(255),
senha varchar(40)
);
select * from Cliente;



