package com.warriors.characters.heroes;

import com.warriors.items.equipments.offense.Spell;
import com.warriors.items.equipments.defense.Philter;


public class Magician extends Hero {

    // CONSTRUCTORS ===================================================================================================

    /**
     * Default constructor
     */
    public Magician(){
        this("", 0, 0);
    }

    /**
     *
     * @param name
     */
    public Magician(String name){
        this(name, 0, 0);
    }

    /**
     *
     * @param name
     * @param lifeLevel
     * @param strength
     */
    public Magician(String name, int lifeLevel, int strength){
        super(name);

        this.setupClassLifeLimits();
        this.setupClassStrengthLimits();

        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

    // SETTERS ========================================================================================================

    /**
     *
     * @param spell
     */
    public void setOffensiveEquipment(Spell spell){
        super.setOffensiveEquipment(spell);
    }

    /**
     *
     * @param philter
     */
    public void setDefensiveEquipment(Philter philter){
        super.setDefensiveEquipment(philter);
    }


    protected void setupClassLifeLimits(){
        this.lifeLimits[0] = 3;
        this.lifeLimits[1] = 6;
    }

    protected void setupClassStrengthLimits(){
        this.strengthLimits[0] = 8;
        this.strengthLimits[1] = 15;
    }

}
