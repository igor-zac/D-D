package com.warriors.customExceptions;

public class CharacterOutOfBoardException extends Exception{

    /**
     * Default constructor
     */
    public CharacterOutOfBoardException(){
        super("You went too far, you have to start again!");
    }
}
