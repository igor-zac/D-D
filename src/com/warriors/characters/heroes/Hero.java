package com.warriors.characters.heroes;

import com.warriors.characters.Character;
import com.warriors.equipments.defense.DefensiveEquipment;
import com.warriors.equipments.offense.OffensiveEquipment;

public abstract class Hero extends Character{

    private static int heroId = 1;

    private final int id;

    protected int[] lifeLimits = new int[2];
    protected int[] strengthLimits = new int[2];

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

    public int getLifeMin(){
        return this.lifeLimits[0];
    }

    public int getLifeMax(){
        return this.lifeLimits[1];
    }

    public int getStrengthMin(){
        return this.strengthLimits[0];
    }

    public int getStrengthMax(){
        return this.strengthLimits[1];
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

    @Override
    public void setStrength(int strength){

        int characterStrength;

        if (strength >= this.getStrengthMin() && strength <= this.getStrengthMax()){
            characterStrength = strength;
        } else if (strength > this.getStrengthMax()) {
            characterStrength = this.getStrengthMax();
        } else {
            characterStrength = this.getStrengthMin();
        }

        if(this.data.containsKey("strength")) {
            this.data.replace("strength", characterStrength);
        } else {
            this.data.put("strength", characterStrength);
        }

    }

    @Override
    public void setLifeLevel(int lifeLevel) {

        int characterLifeLevel;

        if (lifeLevel >= this.getLifeMin() && lifeLevel <= this.getLifeMax()){
            characterLifeLevel = lifeLevel;
        } else if (lifeLevel > this.getLifeMax()) {
            characterLifeLevel = this.getLifeMax();
        } else {
            characterLifeLevel = this.getLifeMin();
        }

        if(this.data.containsKey("lifeLevel")) {
            this.data.replace("lifeLevel", characterLifeLevel);
        } else {
            this.data.put("lifeLevel", characterLifeLevel);
        }

    }

    protected abstract void setupClassLifeLimits();

    protected abstract void setupClassStrengthLimits();

    // CUSTOM METHODS =================================================================================================

    @Override
    public void gainLife(int lifeGained){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel + lifeGained > this.getLifeMax()){
            characterLifeLevel = this.getLifeMax();
        } else {
            characterLifeLevel += lifeGained;
        }

        this.data.replace("lifeLevel", characterLifeLevel);

    }

    @Override
    public void loseLife(int lifeLost){
        int characterLifeLevel = (int)this.data.get("lifeLevel");

        if (characterLifeLevel - lifeLost < this.getLifeMin()){
            characterLifeLevel = this.getLifeMin();
        } else {
            characterLifeLevel -= lifeLost;
        }

        this.data.replace("lifeLevel", characterLifeLevel);


    }

}
