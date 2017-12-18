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
        this.name = name;
        this.id = id;
        this.level = level;
        this.points = points;
        this.chest = chest;
    }

    public Champion() {
        name = "Zilean";
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

    /*
    public static ArrayList<Champion> createList(int numChampions) {
        ArrayList<Champion> champions = new ArrayList<Champion>();

        for (int i = 1; i <= numChampions; i++) {
            champions.add(new Champion("XDD", 4, 5, 6, false));
        }

        return champions;
    }*/

}
