# Restaurantes API

Version preliminar de la solucion al desafio de tyba para desarrolladores backend utilizando spring boot.

Todos los servicios expuestos quedaron en un unico microservicio. Sin embargo, al final de este documento se expone un diagrama en el cual de acuerdo a la consideracion del autor se debe resolver este desafio.

Se utilizo la version free del api de zomato 'https://developers.zomato.com/documentation?lang=es_cl' para la consulta de restaurantes por ciudad o coordenadas.

## Recursos de Autenticacion 

Para poder acceder a los servicios expuestos por el microservicio, primero se debe realizar la respectiva autenticacion y obtener un token de acceso. 

* [Login](docs/login.md) : `POST /auth/login`

### Servicios

Token is provided with the request:

* [Buscar Restaurantes](docs/restaurants.md) : `GET /restaurants/search`
* [Consultar Transacciones](docs/transactions.md) : `GET /restaurants/transactions`
* [Registrar Usuario](docs/register-user.md) : `POST /user/register`

### Construir Aplicacion

* Compilar proyecto java con gradle:
```
gradle clean build
```
* Iniciar proyecto localmente con docker compose
```
docker-compose up
```
Al arrancar el proyecto se puede validar que arranco correctamente si sale el mensaje `Tomcat started on port(s): 9080 (http) with context path ''`
![alt text](docs/images/docker-compose-start.png "Logo Title Text 1")

### Diagrama Pensado para Resolver Desafio
 
* [Repositorio en construccion](https://github.com/ronaltrianat/tyba-challenge)
![alt text](docs/images/diagrama-tyba.png "Logo Title Text 1")
