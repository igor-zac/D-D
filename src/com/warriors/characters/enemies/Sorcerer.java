package com.warriors.characters.enemies;

public class Sorcerer extends Enemy{

    public Sorcerer(){
        this(4, 8);
    }

    public Sorcerer(int lifeLevel, int strength){
        super();
        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

}
