package com.warriors.characters.enemies;

public class Goblin extends Enemy{

    /**
     * Default constructor
     */
    public Goblin(){
        this(4, 8);
    }

    /**
     *
     * @param lifeLevel
     * @param strength
     */
    public Goblin(int lifeLevel, int strength){
        super();
        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

}
