package com.D_D.equipments.offense;

public class Weapon extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    public Weapon(String name, int strength){
        super("Weapon", name, strength);
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Type: Weapon\n" + super.toString();

        return description;
    }
}
