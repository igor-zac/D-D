package com.warriors.characters.enemies;

public class EnemyCreator {

    private final String type;

    public EnemyCreator(String type){
        this.type = type;
    }

    public Enemy create(){
        switch (this.type){
            case "dragon":
                return createDragon();
            case "goblin":
                return createGoblin();
            case "sorcerer":
                return createSorcerer();
            default:
                return null;
        }
    }

    private Dragon createDragon(){
        return new Dragon();
    }

    private Goblin createGoblin(){
        return new Goblin();
    }

    private Sorcerer createSorcerer(){
        return new Sorcerer();
    }
}
