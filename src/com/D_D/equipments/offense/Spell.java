package com.D_D.equipments.offense;

public class Spell extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    public Spell(String name, int strength){
        super("Spell", name, strength);
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Type: Spell\n" + super.toString();

        return description;
    }
}
