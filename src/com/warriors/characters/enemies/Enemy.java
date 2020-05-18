package com.warriors.characters.enemies;

import com.warriors.characters.Character;

public abstract class Enemy extends Character{

    private static int enemyId = 1;

    private final int id;

    // CONSTRUCTORS ===================================================================================================

    /**
     * Default constructor
     */
    protected Enemy(){

        this.id = Enemy.enemyId;
        Enemy.enemyId += 1;

    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String magicianDescription = "Enemy of type " + this.getClass().getSimpleName() + ".\nCurrent life level:" +
                data.get("lifeLevel") + "\nStrength: " + data.get("strength");

        return magicianDescription;
    }


    // GETTERS ========================================================================================================

    /**
     *
     * @return int id
     */
    public int getId(){
        return this.id;
    }


}
