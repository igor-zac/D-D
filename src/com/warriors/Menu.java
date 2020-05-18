package com.warriors;

import com.warriors.characterCreation.CharacterCreationHandler;
import com.warriors.characters.heroes.Hero;
import com.warriors.customExceptions.UserWantsToQuitException;
import com.warriors.game.GameHandler;

import java.util.ArrayList;


public class Menu {

    private CharacterCreationHandler creationHandler;
    private GameHandler gameHandler;
    private ArrayList<Hero> playerList = new ArrayList<Hero>();

    public Menu(){
        this.creationHandler = new CharacterCreationHandler();
        this.gameHandler = new GameHandler();
    }

    public void start(){
        while(this.playerList.size() == 0){
            System.out.println("There are no adventurers registered yet, so let's add yourself to the party!");

            try{
                this.addCharacter();
            } catch (UserWantsToQuitException uWTQ){
                return;
            }
        }


        this.playGame();

    }

    private void addCharacter() throws UserWantsToQuitException {
        Hero myHero = this.creationHandler.registerCharacter();

        if(myHero != null){
            this.playerList.add(myHero);
        }
    }


    private void playGame(){
        this.gameHandler.startGame();
    }

}
