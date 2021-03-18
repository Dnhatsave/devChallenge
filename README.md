# Dev Challenge API RESTful

 Esta API RESTful permite gerenciar as informações das propriedades dos países (identificador – gerado automaticamente, nome, capital, região, sub-região, área).


# Features
* Criar um novo país a partir da API criada com todas as suas propriedades;
* Listar todos os países anteriormente criados;
* Modificar os dados de um país anteriormente criado;
* Eliminar um país anteriormente criado;
* ordenar a lista dos países por qualquer uma das suas propriedades.


# Tecnologias usada

Java 11 e Spring Boot 2

# Endpoints

URL: https://dev-challenge-dercio.herokuapp.com

POST /paises

GET /paises /paises/{id} /paises/{nome} /paises/{capital} /paises/{regiao} /paises/{subregiao} /paises/{area}

PUT /paises/{id}

DELETE /paises/{id}

Paginacao {url}/page?linesPerPage=?&page=?&direction=?


# DEMO

https://dev-challenge-dercio.herokuapp.com/swagger-ui.html


*Todos direitos reservados @dnhatsave *
