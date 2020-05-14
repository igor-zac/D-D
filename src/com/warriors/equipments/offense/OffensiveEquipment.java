package com.warriors.equipments.offense;

import com.warriors.equipments.Equipment;

public abstract class OffensiveEquipment extends Equipment {

    protected int strength;

    // CONSTRUCTORS ===================================================================================================

    protected OffensiveEquipment(String type, String name, int strength){
        super(type, name);
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Type: " + this.getClass().getSimpleName() +
                "\nName: " + this.name +
                "\nStrength: " + this.strength;

        return description;
    }

    // GETTERS ========================================================================================================

    public int getStrength(){
        return this.strength;
    }

}