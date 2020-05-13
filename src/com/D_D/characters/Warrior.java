package com.caca.characters;

import com.caca.equipments.Weapon;
import com.caca.equipments.Shield;

public class Warrior extends Character {

    public static final int MIN_LIFE = 5;
    public static final int MAX_LIFE = 10;

    public static final int MIN_STRENGTH = 5;
    public static final int MAX_STRENGTH = 10;

    // CONSTRUCTORS ===================================================================================================

    public Warrior(){
        super("", Warrior.MIN_LIFE, Warrior.MIN_STRENGTH);
    }

    public Warrior(String name){
        super(name, Warrior.MIN_LIFE, Warrior.MIN_STRENGTH);
    }

    public Warrior(String name, int lifeLevel, int strength){
        super(name, lifeLevel, strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Weapon weapon){
        super.setOffensiveEquipment(weapon);
    }

    public void setDefensiveEquipment(Shield shield){
        super.setDefensiveEquipment(shield);
    }

    public void setStrength(int strength){
        if (strength >= Warrior.MIN_STRENGTH && strength <= Warrior.MAX_STRENGTH){
            this.strength = strength;
        } else if (strength < Warrior.MIN_STRENGTH) {
            this.strength = Warrior.MIN_STRENGTH;
        } else {
            this.strength = Warrior.MAX_STRENGTH;
        }
    }

    public void setLifeLevel(int lifeLevel) {
        if (lifeLevel >= Warrior.MIN_LIFE && lifeLevel <= Warrior.MAX_LIFE){
            this.lifeLevel = lifeLevel;
        } else if (lifeLevel < Warrior.MIN_LIFE) {
            this.lifeLevel = Warrior.MIN_LIFE;
        } else {
            this.lifeLevel = Warrior.MAX_LIFE;
        }

    }

    // CUSTOM METHODS =================================================================================================

    public void gainLife(int lifeGained){
        if (this.lifeLevel + lifeGained > Warrior.MAX_LIFE){
            this.lifeLevel = Warrior.MAX_LIFE;
        } else {
            this.lifeLevel += lifeGained;
        }

    }

    public void loseLife(int lifeLost){
        if (this.lifeLevel - lifeLost < Warrior.MIN_LIFE){
            this.lifeLevel = Warrior.MIN_LIFE;
        } else {
            this.lifeLevel -= lifeLost;
        }

    }

}
