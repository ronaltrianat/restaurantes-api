# Login

Los usuarios deben estar registrados para poder acceder al servicio de login.

**URL** : `/auth/login/`

**Metodo** : `POST`

**Requiere Autenticacion** : NO

**Cuerpo de la solicitud**

```json
{
    "username": "[valid user name]",
    "password": "[password in plain text]"
}
```
## Respuesta exitosa

**Codigo de respuesta** : `200 OK`

**Respuesta ejemplo**

```json
{
  "success": true,
  "message": null,
  "username": "user_name",
  "token": "Bearer *************************************"
}
```

## Respuesta Fallida

**Condicion** : Si el usuario no existe, password invalido o algun otro error.

**Codigo de respuesta** : `200 OK`

**Contenido** :

```json
{
  "success": false,
  "message": "error message.",
  "token": null
}
```
