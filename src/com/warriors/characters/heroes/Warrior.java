package com.warriors.characters.heroes;

import com.warriors.items.equipments.offense.Weapon;
import com.warriors.items.equipments.defense.Shield;


public class Warrior extends Hero {

    // CONSTRUCTORS ===================================================================================================

    /**
     * Default constructor
     */
    public Warrior(){
        this("", 0, 0);
    }

    /**
     *
     * @param name
     */
    public Warrior(String name){
        this(name, 0, 0);
    }

    /**
     *
     * @param name
     * @param lifeLevel
     * @param strength
     */
    public Warrior(String name, int lifeLevel, int strength){
        super(name);

        this.setupClassLifeLimits();
        this.setupClassStrengthLimits();

        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

    // SETTERS ========================================================================================================

    /**
     *
     * @param weapon
     */
    public void setOffensiveEquipment(Weapon weapon){
        super.setOffensiveEquipment(weapon);
    }

    /**
     *
     * @param shield
     */
    public void setDefensiveEquipment(Shield shield){
        super.setDefensiveEquipment(shield);
    }

    protected void setupClassLifeLimits(){
        this.lifeLimits[0] = 5;
        this.lifeLimits[1] = 10;
    }

    protected void setupClassStrengthLimits(){
        this.strengthLimits[0] = 5;
        this.strengthLimits[1] = 10;
    }

}
