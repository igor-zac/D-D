package com.warriors.characters;

import java.util.HashMap;

public abstract class Character {

    protected HashMap<String,Object> data = new HashMap<String,Object>();


    // CONSTRUCTORS ===================================================================================================

    protected Character(int lifeLevel, int strength){

        this.data.put("lifeLevel", lifeLevel);
        this.data.put("strength", strength);

    }

    // GETTERS ========================================================================================================

    public int getLifeLevel(){
        return (int) this.data.get("lifeLevel");
    }

    public int getStrength() {
        return (int) this.data.get("strength");
    }

    // SETTERS ========================================================================================================

    public void setStrength(int strength){
        if (strength > 0){
            this.data.replace("strength", strength);
        }
    }

    public void setLifeLevel(int lifeLevel){
        if (lifeLevel > 0){
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
