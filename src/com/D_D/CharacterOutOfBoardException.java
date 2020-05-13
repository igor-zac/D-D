package com.D_D;

public class CharacterOutOfBoardException extends Exception{

    public CharacterOutOfBoardException(){
        super("You went too far, you have to start again!");
    }
}
