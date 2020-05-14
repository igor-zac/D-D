package com.warriors.characters.enemies;

public class Goblin extends Enemy{

    public Goblin(){
        this(4, 8);
    }

    public Goblin(int lifeLevel, int strength){
        super(lifeLevel, strength);
    }

}
