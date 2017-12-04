# API-Riot

Aplicación para Android básica sobre la consulta de datos de jugadores de **League Of Legends**.

La función principal consiste en la introducción del nombre de invocador del usuario y la muestra de datos personales tanto como los datos básicos de los personajes que más domina.

## Datos Personales a Mostrar

- Nombre De Usuario
- Icono de Invocador
- ID
- Nivel

## Datos de sus Principales Campeones

- Nombre De Campeón
- Icono de Campeón
- Puntos de Campeón
- Nivel de Maestría
- Última vez jugado
- Cofre disponible (El cofre se obtiene al obtener una buena puntuación con el campeón).

## Ejemplo de consulta básica

Una vez dentro de la API SUMMONER-v3, al introducir el nombre de Invocador **"Pablito Terrores"**, obtendremos sus datos de invocador básicos, y de estos obtendremos el dato ID, con el que podremos obtener la información de sus campeones:

Una consulta básica sería:

```
https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/Pablito%20Terrores?api_key=CLAVE_DE_API
```
Por lo que obtendremos un resultado tal como:

```
{"id":32148910,"accountId":35861352,"name":"Pablito Terrores","profileIconId":1228,"revisionDate":1512344905000,"summonerLevel":36}
```
Por tanto, usando el primer dato obtenido, ID, obtenemos los datos de sus principales campeones mediante la API CHAMPION-MASTERY-v3

Ejemplo de consulta siguiendo el mismo nombre de invocador:
```

```

Resultado obtenido en JSON:

![alt text](https://imgur.com/H5Vsowt)

Una vez obtenida esta información en forma de JSON, podremos trabajar en nuestra aplicación en AndroidStudio.
