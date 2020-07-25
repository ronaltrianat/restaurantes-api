# Consulta de Transacciones

Este servicio es el encargado de devolver una lista transacciones realizadas por el usuario. Basicmanete devuelve una lista con la cantidad de transacciones realizadas especificando unicamente los parametros de busqueda.

**URL** : `/restaurants/transactions`

**Metodo** : `GET`

**Requiere Autenticacion** : SI

## Respuesta Exitosa

**Codigo de respuesta** : `200 OK`

**Respuesta de ejemplo**

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

## Respuesta Fallida

**Condicion** : Si nos existen transacciones o algun otro error.

**Codigo respuesta** : `200 OK`

**Contenido** :

```json
{
  "success": false,
  "message": "error message.",
  "transactions": null
}
```
