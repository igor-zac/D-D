package com.warriors.characters.heroes;

import com.warriors.characters.Character;
import com.warriors.equipments.offense.Weapon;
import com.warriors.equipments.defense.Shield;


public class Warrior extends Hero {

    public static final int MIN_LIFE = 5;
    public static final int MAX_LIFE = 10;

    public static final int MIN_STRENGTH = 5;
    public static final int MAX_STRENGTH = 10;

    // CONSTRUCTORS ===================================================================================================

    public Warrior(){
        this("", Warrior.MIN_LIFE, Warrior.MIN_STRENGTH);
    }

    public Warrior(String name){
        this(name, Warrior.MIN_LIFE, Warrior.MIN_STRENGTH);
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

    @Override
    public void setStrength(int strength){
        int characterStrength = (int)this.data.get("strength");

        if (strength >= Warrior.MIN_STRENGTH && strength <= Warrior.MAX_STRENGTH){
            characterStrength = strength;
        } else if (strength < Warrior.MIN_STRENGTH) {
            characterStrength = Warrior.MIN_STRENGTH;
        } else {
            characterStrength = Warrior.MAX_STRENGTH;
        }

        this.data.replace("strength", characterStrength);

    }

    @Override
    public void setLifeLevel(int lifeLevel) {
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (lifeLevel >= Warrior.MIN_LIFE && lifeLevel <= Warrior.MAX_LIFE){
            characterLifeLevel = lifeLevel;
        } else if (lifeLevel < Warrior.MIN_LIFE) {
            characterLifeLevel = Warrior.MIN_LIFE;
        } else {
            characterLifeLevel = Warrior.MAX_LIFE;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

    // CUSTOM METHODS =================================================================================================

    @Override
    public void gainLife(int lifeGained){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel + lifeGained > Warrior.MAX_LIFE){
            characterLifeLevel = Warrior.MAX_LIFE;
        } else {
            characterLifeLevel += lifeGained;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

    @Override
    public void loseLife(int lifeLost){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel - lifeLost < Warrior.MIN_LIFE){
            characterLifeLevel = Warrior.MIN_LIFE;
        } else {
            characterLifeLevel -= lifeLost;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

}
