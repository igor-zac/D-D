package com.warriors.characters.heroes;

import com.warriors.equipments.offense.Spell;
import com.warriors.equipments.defense.Philter;


public class Magician extends Hero {

    // CONSTRUCTORS ===================================================================================================

    public Magician(){
        this("", 0, 0);
    }

    public Magician(String name){
        this(name, 0, 0);
    }

    public Magician(String name, int lifeLevel, int strength){
        super(name);

        this.setupClassLifeLimits();
        this.setupClassStrengthLimits();

        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Spell spell){
        super.setOffensiveEquipment(spell);
    }

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
