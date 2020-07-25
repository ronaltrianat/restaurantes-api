# Restaurantes API

Version preliminar de la solucion al desafio de tyba para desarrolladores backend utilizando spring boot.

Todos los servicios expuestos quedaron en un unico microservicio. Sin embargo, al final de este documento se expone un diagrama en el cual de acuerdo a la consideracion del autor se debe resolver este desafio.

Se utilizo la version free del api de zomato 'https://developers.zomato.com/documentation?lang=es_cl' para la consulta de restaurantes por ciudad o coordenadas.

## Recursos de Autenticacion 

Para poder acceder a los servicios expuestos por el microservicio, primero se debe realizar la respectiva autenticacion y obtener un token de acceso. 

* [Login](docs/login.md) : `POST /auth/login`

## Endpoints that require Authentication

Servicios que requieren autenticacion.

### Current User related

Each endpoint manipulates or displays information related to the User whose
Token is provided with the request:

* [Show info](user/get.md) : `GET /api/user/`
* [Update info](user/put.md) : `PUT /api/user/`

### Account related

Endpoints for viewing and manipulating the Accounts that the Authenticated User
has permissions to access.

* [Show Accessible Accounts](accounts/get.md) : `GET /api/accounts/`
* [Create Account](accounts/post.md) : `POST /api/accounts/`
* [Show An Account](accounts/pk/get.md) : `GET /api/accounts/:pk/`
* [Update An Account](accounts/pk/put.md) : `PUT /api/accounts/:pk/`
* [Delete An Account](accounts/pk/delete.md) : `DELETE /api/accounts/:pk/`
