package com.warriors;

import com.warriors.characters.Character;
import com.warriors.characters.Magician;
import com.warriors.characters.Warrior;

import java.util.Scanner;


public class Menu {

    final private String[] confirmOptions = {"y", "yes"};
    final private String[] declineOptions = {"n", "no"};
    final private String[] exitOptions = {"q", "quit", "exit"};
    final private String[] displayOptions = {"show"};

    final private String[] possibleCharacters = {"Warrior", "Magician"};

    final private String[] characterOptions = {"Character Choice", "Name", "Life Level", "Strength"};
    private Character character;
    private String[] playerChoices;
    private boolean isQuitting;


    public void createCharacter() {
        Scanner scanner = new Scanner(System.in);
        boolean confirmCharacter = false;
        String userInput;


        System.out.println("I'm going to need some information so we can get started on our adventure!\n");


        System.out.println("\n\nSo, tell me about yourself adventurer.");

        while (!confirmCharacter) {

            playerChoices = new String[4];
            System.out.println("Keep in mind that you can quit at any moment, just enter 'q', 'quit' or 'exit'.\n" +
                    "And if you want to check the current status of your character, just type 'show'.");
            for (int optionIndex = 0; optionIndex < characterOptions.length; optionIndex++) {
                chooseOption(scanner, optionIndex);
                if(isQuitting){
                    return;
                }
            }

            System.out.println("Here is what I know about you :");
            displayRecap();

            System.out.println("Do you agree? (Y/n)");

            userInput = scanner.nextLine();
            while (!isInputValid("Confirm", userInput)) {
                System.out.println("I did not understand.");
                userInput = scanner.nextLine();
            }

            for (String option : confirmOptions) {
                if (option.equals(userInput.toLowerCase())) {
                    confirmCharacter = true;
                    break;
                }
            }
        }


        if (playerChoices[0].equals("Warrior")) {
            character = new Warrior(playerChoices[1], Integer.parseInt(playerChoices[2]), Integer.parseInt(playerChoices[3]));
        } else {
            character = new Magician(playerChoices[1], Integer.parseInt(playerChoices[2]), Integer.parseInt(playerChoices[3]));
        }
    }

    private void chooseOption(Scanner scanner, int optionIndex) {
        String option = characterOptions[optionIndex];
        choiceStart(option);

        String userInput = scanner.nextLine();

        if (wantsToQuit(userInput)) {
            quittingMessage();
            isQuitting = true;
            return;
        }

        if (wantsRecap(userInput)) {
            System.out.println("\nYour current status :\n(don't worry you will be able to make changes at the end)\n");
            displayRecap();
        }

        while (!isInputValid(option, userInput)) {
            System.out.println("I did not understand or the input is incorrect, could you repeat please?");
            userInput = scanner.nextLine();
            if (wantsToQuit(userInput)) {
                quittingMessage();
                return;
            }
        }

        if(optionIndex == 0){
            playerChoices[optionIndex] = possibleCharacters[Integer.parseInt(userInput)-1];
        } else {
            playerChoices[optionIndex] = userInput;
        }
    }

    private void choiceStart(String option) {
        switch (option) {
            case "Character Choice":
                System.out.println("Are you: \n1 - A warrior\n2 - A magician\n\n" +
                        "(enter the number corresponding to your choice)\n");
                break;

            case "Name":
                System.out.println("What is your name?\n");
                break;

            case "Life Level":
                System.out.print("What is your current life level?\nAnd don't try to fool me, I know you are a ");
                if (playerChoices[0].equals("Warrior")) {
                    System.out.println("Warrior, so it must be between " + Warrior.MIN_LIFE + " and " + Warrior.MAX_LIFE + "!");
                } else {
                    System.out.println("Magician, so it must be between " + Magician.MIN_LIFE + " and " + Magician.MAX_LIFE + "!");
                }
                break;

            case "Strength":
                System.out.print("What is your strength?\nAgain, don't lie to me, it must be between ");
                if (playerChoices[0].equals("Warrior")) {
                    System.out.println(Warrior.MIN_STRENGTH + " and " + Warrior.MAX_STRENGTH + ".");
                } else {
                    System.out.println(Magician.MIN_STRENGTH + " and " + Magician.MAX_STRENGTH + ".");
                }
                break;

        }
    }

    private boolean isInputValid(String option, String userInput) {

        switch (option) {
            case "Character Choice":
                try {
                    int choice = Integer.parseInt(userInput);
                    if (choice > 0 && choice <= possibleCharacters.length) {
                        return true;
                    }
                } catch (NumberFormatException nfe) {
                }

                break;

            case "Name":
                return true;

            case "Life Level":
                try {
                    int choice = Integer.parseInt(userInput);
                    if (playerChoices[0].equals("Magician")) {
                        if (choice >= 3 && choice <= 6) {
                            return true;
                        }
                    } else {
                        if (choice > 5 && choice <= 10) {
                            return true;
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                break;

            case "Strength":
                try {
                    int choice = Integer.parseInt(userInput);
                    if (playerChoices[0].equals("Magician")) {
                        if (choice > 8 && choice <= 15) {
                            return true;
                        }
                    } else {
                        if (choice > 5 && choice <= 10) {
                            return true;
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                break;
            case "Confirm":
                for (String possibleChoice : confirmOptions) {
                    if (possibleChoice.equals(userInput.toLowerCase())) {
                        return true;
                    }
                }
                for (String possibleChoice : declineOptions) {
                    if (possibleChoice.equals(userInput.toLowerCase())) {
                        return true;
                    }
                }

        }

        return false;
    }

    private boolean wantsRecap(String userInput) {
        for (String option : displayOptions) {
            if (userInput.toLowerCase().equals(option)) {
                return true;
            }
        }
        return false;
    }

    private void displayRecap() {
        for (int i = 0; i < characterOptions.length; i++) {
            System.out.println(characterOptions[i] + " : " + (playerChoices[i] == null ? "" : playerChoices[i]));
        }
    }

    private boolean wantsToQuit(String userInput) {
        for (String option : exitOptions) {
            if (userInput.toLowerCase().equals(option)) {
                return true;
            }
        }
        return false;
    }

    private void quittingMessage() {
        System.out.println("I see you do not want to continue...");
    }

    public void startGame() {
        boolean keepPlaying = false;
        int nbOfCases = 64;
        int currentCase;
        int diceResult;

        do {
          currentCase = 1;

          while(currentCase < nbOfCases){
              diceResult = diceRoll();
              System.out.println("Rolled dice: " + diceResult);

              try {
                  currentCase = move(nbOfCases, currentCase, diceResult);
              } catch (CharacterOutOfBoardException cob){
                  System.out.println(cob.getMessage());
                  currentCase = 1;
              }

              System.out.println("Current case: " + currentCase + "/" + nbOfCases);
          }

          System.out.println("Congratulations, you did it!" +
                  "\n\nDo you want to play again? (Y/n)");

          Scanner sc = new Scanner(System.in);
          String userInput = sc.nextLine();

          if(userInput.toLowerCase().equals("y") || userInput.toLowerCase().equals("yes")){
              keepPlaying = true;
          } else if (!userInput.toLowerCase().equals("n") && !userInput.toLowerCase().equals("no")){
              System.out.println("Fuck it, I don't wanna take every option into account before refactoring.");
          }

          keepPlaying = false;

        } while(keepPlaying);
    }

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
