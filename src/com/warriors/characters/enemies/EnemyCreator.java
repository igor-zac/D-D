package com.warriors.characters.enemies;

public class EnemyCreator {

    private String type;

    /**
     * Default constructor
     */
    public EnemyCreator() {

    }

    /**
     *
     * @param type
     */
    public EnemyCreator(String type){
        this.type = type.toLowerCase();
    }

    /**
     *
     * @return Enemy enemy
     */
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

    /**
     *
     * @param type
     */
    public void setType(String type){
        this.type = type.toLowerCase();
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
