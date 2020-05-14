package com.warriors.board;

import com.warriors.characters.enemies.Enemy;

public class Space {

    private boolean hasItem = false;
    private String item = null;

    private boolean hasEnemy = false;
    private Enemy enemy;

    private boolean isEmpty = true;

    @Override
    public String toString(){
        String description;

        if(isEmpty){
            description = "This space is empty";
        } else {
            if(hasItem){
                description = "You found the following item: " + this.item;
            } else {
                description = "You found an Enemy! It is a " + this.enemy.getClass().getSimpleName();
            }
        }

        return description;
    }

    public void setItem(String item){
        if(isEmpty){
            this.isEmpty = false;
            this.hasItem = true;
            this.item = item;
        }
    }

    public void setEnemy(Enemy enemy){
        if(isEmpty){
            this.isEmpty = false;
            this.hasEnemy = true;
            this.enemy = enemy;
        }
    }
}
