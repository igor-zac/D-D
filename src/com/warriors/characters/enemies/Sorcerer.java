package com.warriors.characters.enemies;

public class Sorcerer extends Enemy{

    public Sorcerer(){
        this(4, 8);
    }

    public Sorcerer(int lifeLevel, int strength){
        super(lifeLevel, strength);
    }

}
