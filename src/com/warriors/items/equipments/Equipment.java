package com.warriors.items.equipments;

public abstract class Equipment {

    protected String name;
    protected String type;

    // CONSTRUCTORS ===================================================================================================

    protected Equipment(String type, String name){
        this.name = name;
        this.type = type;
    }

    // GETTERS ========================================================================================================

    /**
     *
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return String type
     */
    public String getType(){
        return this.type;
    }
}