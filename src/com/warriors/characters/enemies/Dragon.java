package com.warriors.characters.enemies;

public class Dragon extends Enemy{

    public Dragon(){
        this(4, 8);
    }

    public Dragon(int lifeLevel, int strength){
        super(lifeLevel, strength);
    }

}
