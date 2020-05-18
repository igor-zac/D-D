package com.warriors.items.equipments.offense;

public abstract class Weapon extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    /**
     *
     * @param name
     * @param strength
     */
    public Weapon(String name, int strength){
        super("Weapon", name, strength);
    }

}