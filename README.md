# Uala-Twitter-Timeline-feed
Aplicación que gestiona los timelines de tweets de los usuarios, mostrando los tweets de los usuarios seguidos

## Redis
Este modulo utiliza Redis para crear cache de la base de datos de tweets
Para levantar este proyecto, se debe instalar redis.
En windows me funciono el siguiente link:
https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100
Para otro sistema operativo, el siguiente link: https://redis.io/docs/install/install-redis/


# Servicio Timeline

El objetivo de este servicio es mantener al tanto al usuario de los tweets de los usuarios que este siga.

### DER Y UML
No cuenta con base de datos propia, utiliza **REDIS** para guardar en memoria ram una cache de la db Tweet

Esto permite liberar a la base de tweets por tiempos configurables. 

### Dominio
no tiene dominio como tal, timeline se construye sobre un DTO con la informacion obtenida de los servicios Usuario y Tweet
![image](https://github.com/matias14b/Timeline-Uala-Twitter/assets/127508318/b80fa865-e212-4e30-9c4c-12ea6ae6fa6f)

### Diagrama de servicio

A nivel arquitectura se decidio por MVC 
![image](https://github.com/matias14b/Timeline-Uala-Twitter/assets/127508318/4201066a-d38a-497f-8f87-5aeccf9c4ac1)


## API Reference

El servicio TimeLine expone el siguiente servicio:

#### obtener Timeline

```http
  PUT /api/timeline/{idUsuario}?pagina={pagina}&tamanio={tamanio}&sort={sort}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idUsuario`      | `string` | **Requerido**. id del usuario del que necesitas los seguidores para consultar sus Tweets |
| `pagina`      | `int` | **Opcional**. numero de la pagina que quieres consultar|
| `tamanio`      | `int` | **Opcional**. cantidad de tweets |
| `sort`      | `string` | **Opcional**. Criterio de ordenamiento, y el clave del objeto Tweet se tendra en cuenta para este ordenamiento (Ejemplo: fechaCreacion,ASC) |

###### Respuesta
```yaml
{
    "username": "ichiban",
    "usuarioId": 1,
    "tweets": [
        {
            "id": 41,
            "mensaje": "Hola",
            "usuarioCreadorId": 2,
            "fechaCreacion": "25/02/2024 16:21"
        },
        {
            "id": 42,
            "mensaje": "Hola",
            "usuarioCreadorId": 2,
            "fechaCreacion": "25/02/2024 16:21"
        }
    ]
}
```

## Running Tests

Para correr los test, usar el siguiente comando:

```bash
  mvn clean test
```




## Tech Stack


**Server:** Java 17, Spring 3.2.2, MySQL, redis

