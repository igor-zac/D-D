package com.warriors.items.itemBehavior;

import com.warriors.characters.heroes.Hero;

public class AddLife implements PlayerInteraction {

    private int lifeBonus;

    /**
     *
     * @param lifeBonus
     */
    public AddLife(int lifeBonus){
        this.lifeBonus = lifeBonus;
    }

    /**
     *
     * @param hero
     */
    @Override
    public void interact(Hero hero) {
        hero.gainLife(lifeBonus);
    }
}
