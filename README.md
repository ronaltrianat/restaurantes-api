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