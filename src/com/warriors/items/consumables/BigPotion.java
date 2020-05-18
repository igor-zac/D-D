package com.warriors.items.consumables;

import com.warriors.items.itemBehavior.AddLife;

public class BigPotion extends Consumable{

    /**
     * Default constructor
     */
    public BigPotion(){
        this.behavior = new AddLife(5);
    }

}
