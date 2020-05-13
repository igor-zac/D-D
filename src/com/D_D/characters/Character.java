package com.D_D.characters;

import com.D_D.equipments.defense.DefensiveEquipment;
import com.D_D.equipments.offense.OffensiveEquipment;


public abstract class Character {

    protected String name;
    protected int lifeLevel;
    protected int strength;

    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    // CONSTRUCTORS ===================================================================================================

    protected Character(String name, int lifeLevel, int strength){

        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String magicianDescription = "Character of type " + this.getClass().getSimpleName() + ".\nCurrent life level:" +
                lifeLevel + "\nStrength: " + strength;

        if(offensiveEquipment != null) {
            magicianDescription += "\n" + this.offensiveEquipment.getType() + "\n    -Name: " +
                    this.offensiveEquipment.getName() + "\n    -Strength: " + this.offensiveEquipment.getStrength();
        } else {
            magicianDescription += "\nNothing to attack with.";
        }

        if(defensiveEquipment != null) {
            magicianDescription += "\n" + this.defensiveEquipment.getType() + ": " + this.defensiveEquipment;
        } else {
            magicianDescription += "\nNothing to defend yourself with.";
        }

        return magicianDescription;
    }


    // GETTERS ========================================================================================================

    public String getName(){
        return this.name;
    }

    public int getLifeLevel(){
        return this.lifeLevel;
    }

    public int getStrength(){
        return this.strength;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return this.offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment(){
        return this.defensiveEquipment;
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment){
        this.offensiveEquipment = offensiveEquipment;
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment){
        this.defensiveEquipment = defensiveEquipment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStrength(int strength){
        if (strength > 0){
            this.strength = strength;
        }
    }

    public void setLifeLevel(int lifeLevel){
        if (lifeLevel > 0){
            this.lifeLevel = lifeLevel;
        }
    }

    // CUSTOM METHODS =================================================================================================

    public void gainLife(int lifeGained){
        this.lifeLevel += lifeGained;
    }

    public void loseLife(int lifeLost){
        this.lifeLevel -= lifeLost;
    }
}
