package com.warriors.characters.heroes;

import com.warriors.characters.Character;
import com.warriors.equipments.defense.DefensiveEquipment;
import com.warriors.equipments.offense.OffensiveEquipment;

public abstract class Hero extends Character{

    private static int heroId = 1;

    private final int id;

    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    // CONSTRUCTORS ===================================================================================================

    protected Hero(String name){

        this.id = Hero.heroId;
        Hero.heroId += 1;

        this.setName(name);

    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String magicianDescription = "Character of type " + this.getClass().getSimpleName() + ".\nCurrent life level:" +
                data.get("lifeLevel") + "\nStrength: " + data.get("strength");

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

    public int getId(){
        return this.id;
    }

    public String getName(){
        return (String)this.data.get("name");
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return this.offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment(){
        return this.defensiveEquipment;
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment){
        if(offensiveEquipment != null){
            this.offensiveEquipment = offensiveEquipment;
        }
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment){
        if(defensiveEquipment != null){
            this.defensiveEquipment = defensiveEquipment;
        }
    }

    public void setName(String name){
        if(name != null){
            this.data.put("name", name);
        } else {
            this.data.put("name", "");
        }
    }
}
