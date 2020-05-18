package com.warriors.items.equipments;

import com.warriors.items.equipments.offense.OffensiveEquipment;
import com.warriors.items.equipments.offense.spells.Fireball;
import com.warriors.items.equipments.offense.spells.Thunderbolt;
import com.warriors.items.equipments.offense.weapons.Mace;
import com.warriors.items.equipments.offense.weapons.Sword;

public class EquipmentCreator {

    private String type;

    /**
     * Default constructor
     */
    public EquipmentCreator(){}

    /**
     *
     * @param type
     */
    public EquipmentCreator(String type){
        this.type = type.toLowerCase();
    }

    /**
     *
     * @param type
     */
    public void setType(String type){
        this.type = type.toLowerCase();
    }

    /**
     *
     * @return OffensiveEquipment equipment
     */
    public OffensiveEquipment create(){
        switch(this.type){
            case "mace":
                return createMace();
            case "sword":
                return createSword();
            case "fireball":
                return createFireball();
            case "thunderbolt":
                return createThunderbolt();
            default:
                return null;
        }
    }

    private Mace createMace(){
        return new Mace();
    }

    private Sword createSword(){
        return new Sword();
    }

    private Fireball createFireball(){
        return new Fireball();
    }

    private Thunderbolt createThunderbolt(){
        return new Thunderbolt();
    }
}
