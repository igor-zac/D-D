package com.warriors.items.itemBehavior;

import com.warriors.characters.heroes.Hero;
import com.warriors.items.equipments.offense.OffensiveEquipment;

public class AddAttackEquipment implements PlayerInteraction {

    private OffensiveEquipment offensiveEquipment;
    private String heroType;

    /**
     *
     * @param OE
     * @param heroType
     */
    public AddAttackEquipment(OffensiveEquipment OE, String heroType){
        this.offensiveEquipment = OE;
    }

    /**
     *
     * @param hero
     */
    @Override
    public void interact(Hero hero) {
        if(hero.getClass().getSimpleName().equals(this.heroType)){
            hero.setOffensiveEquipment((OffensiveEquipment)this.offensiveEquipment);
        }
    }
}
