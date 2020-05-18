package com.warriors.items.consumables;

import com.warriors.items.itemBehavior.AddLife;

public class StandardPotion extends Consumable{

    /**
     * Default constructor
     */
    public StandardPotion(){
        this.behavior = new AddLife(2);
    }

}
