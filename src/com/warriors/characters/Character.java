package com.warriors.characters;

import com.warriors.equipments.defense.DefensiveEquipment;
import com.warriors.equipments.offense.OffensiveEquipment;

import java.util.Hashtable;

public abstract class Character {

    private static int characterId = 1;
    public static final String[] characterAttributes = {"name", "lifeLevel", "strength"};


    private int playerId;

    protected Hashtable<String,Object> data = new Hashtable<String,Object>();

//    protected String name;
//    protected int lifeLevel;
//    protected int strength;

    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    // CONSTRUCTORS ===================================================================================================

    protected Character(String name, int lifeLevel, int strength){

        this.playerId = Character.characterId;
        Character.characterId += 1;

        this.data.put(characterAttributes[0], name);
        this.data.put(characterAttributes[1], lifeLevel);
        this.data.put(characterAttributes[2], strength);

//        this.name = name;
//        this.lifeLevel = lifeLevel;
//        this.strength = strength;
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

    public int getPlayerId(){
        return this.playerId;
    }

    public String getName(){
        return (String)this.data.get("name");
    }

    public int getLifeLevel(){
        return (int)this.data.get("lifeLevel");
    }

    public int getStrength(){
        return (int)this.data.get("strength");
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
        this.data.put("name", name);
    }

    public void setStrength(int strength){
        if (strength > 0){
//            this.strength = strength;
            this.data.replace("strength", strength);
        }
    }

    public void setLifeLevel(int lifeLevel){
        if (lifeLevel > 0){
//            this.lifeLevel = lifeLevel;
            this.data.replace("lifeLevel", lifeLevel);
        }
    }

    // CUSTOM METHODS =================================================================================================

    public void gainLife(int lifeGained){
       int characterLifeLevel = (int)this.data.get("lifeLevel");
       characterLifeLevel += lifeGained;
       this.data.replace("lifeLevel", characterLifeLevel);
    }

    public void loseLife(int lifeLost){
        int characterLifeLevel = (int)this.data.get("lifeLevel");
        characterLifeLevel -= lifeLost;
        this.data.replace("lifeLevel", characterLifeLevel);
    }
}
