package com.warriors.characters.heroes;

import com.warriors.equipments.offense.Weapon;
import com.warriors.equipments.defense.Shield;


public class Warrior extends Hero {

    // CONSTRUCTORS ===================================================================================================

    public Warrior(){
        this("", 0, 0);
    }

    public Warrior(String name){
        this(name, 0, 0);
    }

    public Warrior(String name, int lifeLevel, int strength){
        super(name);

        this.setupClassLifeLimits();
        this.setupClassStrengthLimits();

        this.setLifeLevel(lifeLevel);
        this.setStrength(strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Weapon weapon){
        super.setOffensiveEquipment(weapon);
    }

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
