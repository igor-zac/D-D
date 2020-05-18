package com.warriors.game.board;

import com.warriors.characters.enemies.Enemy;
import com.warriors.items.consumables.Consumable;
import com.warriors.items.equipments.offense.OffensiveEquipment;

public class Space {

    private boolean hasItem = false;
    private Consumable item;

    private boolean hasEnemy = false;
    private Enemy enemy;

    private boolean hasEquipment = false;
    private OffensiveEquipment equipment;

    private boolean isEmpty = true;

    @Override
    public String toString(){
        String description;

        if(isEmpty){
            description = "This space is empty";
        } else {
            if(hasItem){
                description = "You found the following item: " + this.item.getClass().getSimpleName();
            } else if(hasEquipment) {
                description = "You found the following equipment: " + this.equipment.getClass().getSimpleName();
            } else {
                description = "You found an Enemy! It is a " + this.enemy.getClass().getSimpleName();
            }
        }

        return description;
    }

    /**
     *
     * @param item
     */
    public void setItem(Consumable item){
        if(isEmpty){
            this.isEmpty = false;
            this.hasItem = true;
            this.item = item;
        }
    }

    /**
     *
     * @param enemy
     */
    public void setEnemy(Enemy enemy){
        if(isEmpty){
            this.isEmpty = false;
            this.hasEnemy = true;
            this.enemy = enemy;
        }
    }

    /**
     *
     * @param equipment
     */
    public void setEquipment(OffensiveEquipment equipment){
        if(isEmpty){
            this.isEmpty = false;
            this.hasEquipment = true;
            this.equipment = equipment;
        }
    }

    /**
     *
     * @return boolean isEmpty
     */
    public boolean isEmpty(){
        return this.isEmpty;
    }
}
