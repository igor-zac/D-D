package com.warriors.items.equipments.offense.weapons;

import com.warriors.characters.heroes.Hero;
import com.warriors.items.itemBehavior.PlayerInteraction;
import com.warriors.items.equipments.offense.Weapon;
import com.warriors.items.itemBehavior.AddAttackEquipment;

public class Sword extends Weapon {

    private PlayerInteraction behavior;

    /**
     * Default constructor
     */
    public Sword(){
        super("Sword", 5);
        this.behavior = new AddAttackEquipment(this, "Warrior");
    }

    /**
     *
     * @param hero
     */
    public void interact(Hero hero){
        this.behavior.interact(hero);
    }

}
