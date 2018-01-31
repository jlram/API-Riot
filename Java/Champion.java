package com.example.eag.myapplication;

import java.util.ArrayList;

/**
 * Created by jlram on 16/12/2017.
 */

public class Champion {

    String name;
    int id;
    int level;
    int points;
    boolean chest;

    public Champion(String name, int id, int level, int points, boolean chest) {
        /*
        * A pesar de tener una variable name, no he sido capaz de sacarlo de la api, ya que solo me daba
        * el ID del personaje. Aun asi, lo dejo para poder seguir trabajando en ellos.
        */
        this.name = name;
        this.id = id;
        this.level = level;
        this.points = points;
        /* El booleano chest sera true cuando el jugador ya haya obtenido una buena puntuacion con el
        * personaje dado. Una vez conseguido, no conseguira nunca mas un cofre. En caso de que este false chest
        * quiere decir que el jugador aun no ha obtenido el cofre de bonificacion
        */
        this.chest = chest;
    }

    public Champion() {
        name = "";
        id = 0;
        level = 0;
        points = 0;
        chest = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isChest() {
        return chest;
    }

    public void setChest(boolean chest) {
        this.chest = chest;
    }

}
