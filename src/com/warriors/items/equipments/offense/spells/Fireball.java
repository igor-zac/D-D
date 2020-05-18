package com.warriors.items.equipments.offense.spells;

import com.warriors.characters.heroes.Hero;
import com.warriors.items.itemBehavior.PlayerInteraction;
import com.warriors.items.equipments.offense.Spell;
import com.warriors.items.itemBehavior.AddAttackEquipment;

public class Fireball extends Spell {

    private PlayerInteraction behavior;

    /**
     * Default constructor
     */
    public Fireball(){
        super("Fireball", 5);
        this.behavior = new AddAttackEquipment(this, "Magician");
    }

    /**
     *
     * @param hero
     */
    public void interact(Hero hero){
        this.behavior.interact(hero);
    }

}
