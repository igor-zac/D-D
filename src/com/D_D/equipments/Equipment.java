package com.D_D.equipments;

public abstract class Equipment {

    protected String name;
    protected String type;

    // CONSTRUCTORS ===================================================================================================

    protected Equipment(String type, String name){
        this.name = name;
        this.type = type;
    }

    // GETTERS ========================================================================================================

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }
}