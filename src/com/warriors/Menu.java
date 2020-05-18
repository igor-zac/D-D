package com.warriors;

import com.warriors.characters.heroes.Hero;

import java.util.ArrayList;


public class Menu {

    private CharacterCreationHandler creationHandler;
    private ArrayList<Hero> playerList = new ArrayList<Hero>();

    public Menu(){
        this.creationHandler = new CharacterCreationHandler();
    }

    public void start(){
        while(this.playerList.size() == 0){
            System.out.println("There are no adventurers registered yet, so let's add yourself to the party!");
            this.addCharacter();
        }


    }

    private void addCharacter(){
        Hero myHero = this.creationHandler.registerCharacter();

        if(myHero != null){
            this.playerList.add(myHero);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void startGame() {
//        boolean keepPlaying = false;
//        int currentCase;
//        int diceResult;
//        Scanner sc = new Scanner(System.in);
//
//        GameBoard gB = new GameBoard();
//
//        do {
//          currentCase = 1;
//
//          while(currentCase < gB.NB_OF_SPACES){
//              diceResult = diceRoll();
//              System.out.println("Rolled dice: " + diceResult);
//
//              try {
//                  currentCase = move(gB.NB_OF_SPACES, currentCase, diceResult);
//              } catch (CharacterOutOfBoardException cob){
//                  System.out.println(cob.getMessage());
//                  currentCase = 1;
//              }
//
//              System.out.println("Current case: " + currentCase + "/" + gB.NB_OF_SPACES);
//              System.out.println(gB.getCurrentSpace(currentCase).toString());
//
//              sc.nextLine();
//          }
//
//          System.out.println("Congratulations, you did it!" +
//                  "\n\nDo you want to play again? (Y/n)");
//
//          String userInput = sc.nextLine();
//
//          if(userInput.toLowerCase().equals("y") || userInput.toLowerCase().equals("yes")){
//              keepPlaying = true;
//          } else if (!userInput.toLowerCase().equals("n") && !userInput.toLowerCase().equals("no")){
//              System.out.println("Fuck it, I don't wanna take every option into account before refactoring.");
//          }
//
//        } while(keepPlaying);
//    }

    private int diceRoll(){
        return (int) Math.ceil(Math.random() * 6);
    }

    private int move(int nbOfCases, int currentCase, int diceResult) throws CharacterOutOfBoardException {
        if(currentCase + diceResult > nbOfCases){
            throw new CharacterOutOfBoardException();
        } else {
            return currentCase + diceResult;
        }
    }

}
