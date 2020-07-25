# Registrar Usuario

Servicio encargado de realizar el registro del usuario. Se requiere unicamente nombre de usuario y contraseña.

**URL** : `/user/register`

**METODO** : `POST`

**Requiere Autenticacion** : NO

**Body Request**

```json
{
    "username": "[valid user name]",
    "password": "[password in plain text]"
}
```
## Success Response

**Code** : `200 OK`

**Content example**

```json
{
  "success": true,
  "message": "User successfully registered."
}
```

## Error Response

**Condition** : Si el usuario ya existe o algun otro error.

**Code** : `200 OK`

**Content** :

```json
{
  "success": false,
  "message": "error message."
}
```
