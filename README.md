# API-Riot
**Update 30/12** - Riot Games ha aprobado mi solicitud para poder usar mi aplicación frente al público dándome una clave de API de desarrollador. Continuaré el desarrollo de mi aplicación el verano de 2018.

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

Una vez dentro de la **API __SUMMONER-v3__**, al introducir el nombre de Invocador **"Pablito Terrores"**, obtendremos sus datos de invocador básicos, y de estos obtendremos el dato **ID**, con el que podremos obtener la información de sus campeones:

Una consulta básica sería:

```
https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/Pablito%20Terrores?api_key=CLAVE_DE_API
```
Por lo que obtendremos un resultado tal como:

```
{"id":32148910,"accountId":35861352,"name":"Pablito Terrores","profileIconId":1228,"revisionDate":1512344905000,"summonerLevel":36}
```
Por tanto, usando el primer dato obtenido, **ID**, obtenemos los datos de sus principales campeones mediante la **API __CHAMPION-MASTERY-v3__**

Ejemplo de consulta siguiendo el mismo nombre de invocador:
```
https://euw1.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/32148910?api_key=CLAVE_DE_API
```

Resultado obtenido en JSON:

![Resultado](https://i.imgur.com/jmdcPpz.png)

Una vez obtenida esta información en forma de JSON, podremos trabajar en nuestra aplicación en AndroidStudio.
