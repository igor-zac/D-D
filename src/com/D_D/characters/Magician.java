package com.caca.characters;

import com.caca.equipments.Spell;
import com.caca.equipments.Philter;

public class Magician extends Character {

    public static final int MIN_LIFE = 3;
    public static final int MAX_LIFE = 6;

    public static final int MIN_STRENGTH = 8;
    public static final int MAX_STRENGTH = 15;

    // CONSTRUCTORS ===================================================================================================

    public Magician(){
        super("", Magician.MIN_LIFE, Magician.MIN_STRENGTH);
    }

    public Magician(String name){
        super(name, Magician.MIN_LIFE, Magician.MIN_STRENGTH);
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

    public void setStrength(int strength){
        if (strength >= Magician.MIN_STRENGTH && strength <= Magician.MAX_STRENGTH){
            this.strength = strength;
        } else if (strength < Magician.MIN_STRENGTH) {
            this.strength = Magician.MIN_STRENGTH;
        } else {
            this.strength = Magician.MAX_STRENGTH;
        }
    }

    public void setLifeLevel(int lifeLevel) {
        if (lifeLevel >= Magician.MIN_LIFE && lifeLevel <= Magician.MAX_LIFE){
            this.lifeLevel = lifeLevel;
        } else if (lifeLevel < Magician.MIN_LIFE) {
            this.lifeLevel = Magician.MIN_LIFE;
        } else {
            this.lifeLevel = Magician.MAX_LIFE;
        }

    }

    // CUSTOM METHODS =================================================================================================

    public void gainLife(int lifeGained){
        if (this.lifeLevel + lifeGained > Magician.MAX_LIFE){
            this.lifeLevel = Magician.MAX_LIFE;
        } else {
            this.lifeLevel += lifeGained;
        }

    }

    public void loseLife(int lifeLost){
        if (this.lifeLevel - lifeLost < Magician.MIN_LIFE){
            this.lifeLevel = Magician.MIN_LIFE;
        } else {
            this.lifeLevel -= lifeLost;
        }

    }

}
