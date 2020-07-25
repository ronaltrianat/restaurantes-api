# Login

Los usuarios deben estar registrados para poder acceder al servicio de login.

**URL** : `/auth/login/`

**Method** : `POST`

**Auth required** : NO

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
  "message": null,
  "username": "user_name",
  "token": "Bearer *************************************"
}
```

## Error Response

**Condition** : If 'username' and 'password' combination is wrong.

**Code** : `200 OK`

**Content** :

```json
{
  "success": false,
  "message": "error message.",
  "token": null
}
```
