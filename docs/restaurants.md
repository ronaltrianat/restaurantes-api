# Consulta de Restaurantes

Este servicio es el encargado de devolver una lista de restaurantes de acuerdo al id de una ciudad o las coordenadas de la misma.

**URL** : `/restaurants/search?city_id=xxxx&lat=111111&lon=222222`

**Method** : `GET`

**Auth required** : YES

**Parameters Request**
* citi_id : Identificador de la ciudad(Ejemplo:280, 2809).
* lat : Latitud(Ejemplo: 40.6643)
* lon : Longitud(Ejemplo: -73.9385)

## Success Response

**Code** : `200 OK`

**Content example**

/restaurants/search?city_id=2809
```json
{
  "success": true,
  "message": null,
  "establishments": [
    {
      "establishment": {
        "id": 21,
        "name": "Quick Bites"
      }
    },
    {
      "establishment": {
        "id": 7,
        "name": "Bar"
      }
    },
    {
      "establishment": {
        "id": 16,
        "name": "Casual Dining"
      }
    },
    {
      "establishment": {
        "id": 41,
        "name": "Beverage Shop"
      }
    },
    {
      "establishment": {
        "id": 295,
        "name": "Noodle Shop"
      }
    }
  ]
}
```

## Error Response

**Condition** : Si nos existen restaurantes o algun otro error.

**Code** : `200 OK`

**Content** :

```json
{
  "success": false,
  "message": "error message.",
  "establishments": null
}
```
