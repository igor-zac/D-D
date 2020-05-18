package com.warriors.characters.enemies;

public class Dragon extends Enemy{

    /**
     * Default constructor
     */
    public Dragon(){
        this(4, 8);
    }

    /**
     *
     * @param lifeLevel
     * @param strength
     */
    public Dragon(int lifeLevel, int strength){
        super();
        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

}
