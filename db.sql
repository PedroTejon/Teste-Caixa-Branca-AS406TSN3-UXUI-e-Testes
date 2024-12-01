CREATE DATABASE CaixaBranca;
USE CaixaBranca;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(30) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    nome VARCHAR(250) NOT NULL
);

INSERT INTO Usuarios (login, senha, nome) VALUES ('testonildo@gmail.com', 'teste123', 'Testonildo Oliveira'),
('fulano2003@hotmail.com', 'fulano123', 'Fulano da Silva'),
('valtinho@gmail.com', 'valtovaltomaisalto', 'Valtinho da 2');
