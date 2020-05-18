package com.warriors.items.consumables;

import com.warriors.characters.heroes.Hero;
import com.warriors.items.itemBehavior.PlayerInteraction;

public abstract class Consumable {

    protected PlayerInteraction behavior;

    /**
     *
     * @param hero
     */
    public void interact(Hero hero){
        this.behavior.interact(hero);
    }

    @Override
    public String toString(){
        String description = "This is a " + this.getClass().getSimpleName();
        return description;
    }
}
