package com.warriors.characters.enemies;

public class Sorcerer extends Enemy{

    /**
     * Default constructor
     */
    public Sorcerer(){
        this(4, 8);
    }

    /**
     *
     * @param lifeLevel
     * @param strength
     */
    public Sorcerer(int lifeLevel, int strength){
        super();
        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

}
