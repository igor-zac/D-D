package com.warriors;

import com.warriors.board.GameBoard;
import com.warriors.characters.heroes.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GameHandler {

    private ArrayList<Hero> playerList;
    private final GameBoard board;
    private final Scanner scanner;

    private List<Integer> DebugArray;
    private Iterator debugIterator;

    public GameHandler(){
        this(null);
    }

    public GameHandler(ArrayList<Hero> playerList){
        this.playerList = playerList;
        this.board = new GameBoard();
        this.scanner = new Scanner(System.in);
    }

    public void setPlayerList(ArrayList<Hero> playerList){
        this.playerList = playerList;
    }

    public void startGame(){
        boolean keepPlaying = false;
        int currentCase;
        int diceResult;

        this.initDebugMode();


        do {
            currentCase = 1;

            while(currentCase < board.NB_OF_SPACES){
                diceResult = (Main.DEBUG ? debugValue() : diceRoll());
                System.out.println("Rolled dice: " + diceResult);

                try {
                    currentCase = move(board.NB_OF_SPACES, currentCase, diceResult);
                } catch (CharacterOutOfBoardException cob){
                    System.out.println(cob.getMessage());
                    currentCase = 1;
                }

                System.out.println("Current case: " + currentCase + "/" + board.NB_OF_SPACES);
                System.out.println(board.getCurrentSpace(currentCase).toString());

                this.scanner.nextLine();
            }

            System.out.println("Congratulations, you did it!" +
                    "\n\nDo you want to play again? (Y/n)");

            String userInput = this.scanner.nextLine();

            if(userInput.toLowerCase().equals("y") || userInput.toLowerCase().equals("yes")){
                keepPlaying = true;
            } else if (!userInput.toLowerCase().equals("n") && !userInput.toLowerCase().equals("no")){
                System.out.println("Fuck it, I don't wanna take every option into account before refactoring.");
            }

        } while(keepPlaying);
    }

    private int diceRoll(){
        return (int) Math.ceil(Math.random() * 6);
    }

    private int debugValue(){
        if(this.debugIterator.hasNext()){
            return (int)debugIterator.next();
        } else {
            return 1;
        }
    }

    private int move(int nbOfCases, int currentCase, int diceResult) throws CharacterOutOfBoardException {
        if(currentCase + diceResult > nbOfCases){
            throw new CharacterOutOfBoardException();
        } else {
            return currentCase + diceResult;
        }
    }

    private void initDebugMode(){

        this.DebugArray = new ArrayList<Integer>();

       try{
           File debugFile = new File(Main.debugFileName);
           Scanner fileReader = new Scanner(debugFile);
           while (fileReader.hasNextLine()){
               String data = fileReader.nextLine();
               for(String value : data.split(",")){
                   this.DebugArray.add(Integer.parseInt(value));
               }
           }
       } catch (FileNotFoundException e){
           System.out.println("Debug file not found");
           Main.DEBUG = false;
       } catch (NumberFormatException nfe){
           System.out.println("Incorrect debug value in debug file");
           Main.DEBUG = false;
       }

       this.debugIterator = DebugArray.iterator();
    }

}
