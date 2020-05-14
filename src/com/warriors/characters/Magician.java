package com.warriors.characters;

import com.warriors.equipments.offense.Spell;
import com.warriors.equipments.defense.Philter;


public class Magician extends Character {

    public static final int MIN_LIFE = 3;
    public static final int MAX_LIFE = 6;

    public static final int MIN_STRENGTH = 8;
    public static final int MAX_STRENGTH = 15;

    // CONSTRUCTORS ===================================================================================================

    public Magician(){
        this("", Magician.MIN_LIFE, Magician.MIN_STRENGTH);
    }

    public Magician(String name){
        this(name, Magician.MIN_LIFE, Magician.MIN_STRENGTH);
    }

    public Magician(String name, int lifeLevel, int strength){
        super(name, lifeLevel, strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Spell spell){
        super.setOffensiveEquipment(spell);
    }

    public void setDefensiveEquipment(Philter philter){
        super.setDefensiveEquipment(philter);
    }

    @Override
    public void setStrength(int strength){
        int characterStrength = (int)this.data.get("strength");

        if (strength >= Magician.MIN_STRENGTH && strength <= Magician.MAX_STRENGTH){
            characterStrength = strength;
        } else if (strength < Magician.MIN_STRENGTH) {
            characterStrength = Magician.MIN_STRENGTH;
        } else {
            characterStrength = Magician.MAX_STRENGTH;
        }

        this.data.replace("strength", characterStrength);
    }

    @Override
    public void setLifeLevel(int lifeLevel) {
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (lifeLevel >= Magician.MIN_LIFE && lifeLevel <= Magician.MAX_LIFE){
            characterLifeLevel = lifeLevel;
        } else if (lifeLevel < Magician.MIN_LIFE) {
            characterLifeLevel = Magician.MIN_LIFE;
        } else {
            characterLifeLevel = Magician.MAX_LIFE;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

    // CUSTOM METHODS =================================================================================================

    @Override
    public void gainLife(int lifeGained){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel + lifeGained > Magician.MAX_LIFE){
            characterLifeLevel = Magician.MAX_LIFE;
        } else {
            characterLifeLevel += lifeGained;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

    @Override
    public void loseLife(int lifeLost){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel - lifeLost < Magician.MIN_LIFE){
            characterLifeLevel = Magician.MIN_LIFE;
        } else {
            characterLifeLevel -= lifeLost;
        }

        this.data.replace("lifeLevel", characterLifeLevel);


    }

}
