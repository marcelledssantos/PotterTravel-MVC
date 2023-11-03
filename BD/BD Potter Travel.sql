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
CREATE TABLE viagem(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
origem VARCHAR(255),
destino VARCHAR(255),
data_viagem DATE,
horario VARCHAR(255)
);


create table cia_aerea(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(100)
);

create table passagem_aerea(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_viagem int,
id_cia_aerea int
);

create table hotel(
id INT NOT NULL auto_increment PRIMARY KEY,
nome varchar(255),
cidade varchar(255)
);

create table pacote_viagem(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_passagem_aerea int,
id_hotel int, 
preco decimal,
forma_pagamento varchar(40)
);

create table cliente_pacote(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_cliente int,
id_pacote_viagem int
);

create table promocao(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_pacote_viagem int,
novo_preco decimal
);

select * from Cliente;



