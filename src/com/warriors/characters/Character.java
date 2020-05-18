package com.warriors.characters;

import java.util.HashMap;

public abstract class Character {

    protected HashMap<String,Object> data = new HashMap<String,Object>();

    // GETTERS ========================================================================================================

    /**
     *
     * @return int LifeLevel
     */
    public int getLifeLevel(){
        return (int) this.data.get("lifeLevel");
    }

    /**
     *
     * @return int Strength
     */
    public int getStrength() {
        return (int) this.data.get("strength");
    }

    // SETTERS ========================================================================================================

    /**
     *
     * @param strength
     */
    public void setStrength(int strength){
        if (strength > 0){
            this.data.replace("strength", strength);
        } else {
            this.data.replace("strength", 1);
        }
    }

    /**
     *
     * @param lifeLevel
     */
    public void setLifeLevel(int lifeLevel){
        if (lifeLevel > 0){
            this.data.replace("lifeLevel", lifeLevel);
        } else {
            this.data.replace("lifeLevel", 1);
        }
    }

    // CUSTOM METHODS =================================================================================================

    /**
     *
     * @param lifeGained
     */
    public void gainLife(int lifeGained){
       int characterLifeLevel = (int)this.data.get("lifeLevel");
       characterLifeLevel += lifeGained;
       this.data.replace("lifeLevel", characterLifeLevel);
    }

    /**
     *
     * @param lifeLost
     */
    public void loseLife(int lifeLost){
        int characterLifeLevel = (int)this.data.get("lifeLevel");
        characterLifeLevel -= lifeLost;
        this.data.replace("lifeLevel", characterLifeLevel);
    }

}
