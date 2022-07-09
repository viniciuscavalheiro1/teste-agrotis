## Applicação para vaga backend 

#### Tecnologias utilizadas
* Java 17
* SpringBoot
* MySql
* Docker e Docker-compose

Optei por criar um banco de dados por linha de comandos, como é um teste preferi utilizar assim para demonstrar conhecimento.

Poderia fazer com ORM mapeando as entidades, mas preferi assim.

#### Rodar a aplicação

O banco e a aplicação irão rodar em containers 

abra o terminal 

> mvn clean install

nvm vai fazer um build para compilar, agora é subir o banco e a aplicação

> docker-compose up --build --force-recreate

pronto, a API já vai estar em execução, mas para funcionar temos que criar o banco de dados
Conectar um MySql WorkBeach
> localhost
> 
> sem senha
>
> port 3306

> create database teste_agrotis_db;

Agora só rodar o restante do SQL na raiz do projeto dentro do MySql WorkBeach 
> ./script_banco_mysql.sql

Queria ter tido mais tempo para fazer o Deploy da API.