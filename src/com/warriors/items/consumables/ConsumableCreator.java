package com.warriors.items.consumables;

public class ConsumableCreator {

    private String type;

    /**
     * Default constructor
     */
    public ConsumableCreator(){}

    /**
     *
     * @param type
     */
    public ConsumableCreator(String type){
        this.type = type.toLowerCase();
    }

    /**
     *
     * @return Consumable item
     */
    public Consumable create(){
        switch (this.type){
            case "bigpotion":
                return createBigPotion();
            case "stdpotion":
                return createStandardPotion();
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

    private BigPotion createBigPotion() {
        return new BigPotion();
    }

    private StandardPotion createStandardPotion() {
        return new StandardPotion();
    }
}
