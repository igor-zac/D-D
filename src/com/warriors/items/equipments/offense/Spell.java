package com.warriors.items.equipments.offense;

public abstract class Spell extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    /**
     *
     * @param name
     * @param strength
     */
    public Spell(String name, int strength){
        super("Spell", name, strength);
    }

}