# Consulta de Transacciones

Este servicio es el encargado de devolver una lista transacciones realizadas por el usuario. Basicmanete devuelve una lista con la cantidad de transacciones realizadas especificando unicamente los parametros de busqueda.

**URL** : `/restaurants/transactions`

**Method** : `GET`

**Auth required** : YES

## Success Response

**Code** : `200 OK`

**Content example**

/restaurants/search?city_id=2809
```json
{
  "success": true,
  "message": null,
  "transactions": [
    {
      "id": 1595701253346,
      "params": "{city_id=[280]}",
      "username": "user"
    },
    {
      "id": 1595701261896,
      "params": "{city_id=[280]}",
      "username": "user"
    },
    {
      "id": 1595702164269,
      "params": "{city_id=[280]}",
      "username": "user"
    },
    {
      "id": 1595702686666,
      "params": "{city_id=[280]}",
      "username": "user"
    }
  ]
}
```

## Error Response

**Condition** : Si nos existen transacciones o algun otro error.

**Code** : `200 OK`

**Content** :

```json
{
  "success": false,
  "message": "error message.",
  "transactions": null
}
```
