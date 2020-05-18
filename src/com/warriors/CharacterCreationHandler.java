package com.warriors;

import com.warriors.characters.heroes.Hero;
import com.warriors.characters.heroes.HeroCreator;

import java.util.Scanner;

public class CharacterCreationHandler {

    private final Scanner scanner;
    private final CLICreationNarrator narrator;
    private final InputValidator validator;
    private final HeroCreator creator;

    private Hero hero;
    private boolean finishedCreating = false;

    final private String[] characterOptions = {"Character Choice", "Name", "Life Level", "Strength"};


    public CharacterCreationHandler() {
        this.scanner = new Scanner(System.in);
        this.narrator = new CLICreationNarrator();
        this.validator = new InputValidator();
        this.creator = new HeroCreator();
    }

    public Hero registerCharacter() {

        this.narrator.narrate("Welcome");

        while (!finishedCreating) {

            this.narrator.narrate("NavigationInfo");

            for (int i = 0; i < characterOptions.length; i++) {
                try {
                    setupCharacterOption(characterOptions[i]);
                } catch (userWantsRecapException uWRE) {
                    i--;
                } catch (userWantsToQuitException uWTQ){
                    return null;
                }
            }

            this.narrator.narrate("Recap");

            System.out.println("Do you agree? (Y/n)");

            String userInput = this.scanner.nextLine();

            while (!(validator.validate("Confirm", userInput) || validator.validate("Decline", userInput))) {

                this.narrator.narrate("TinyError");

                userInput = this.scanner.nextLine();
            }

            if(validator.validate("Confirm", userInput)){
                this.finishedCreating = true;
            }

        }

        return this.hero;
    }

    private void setupCharacterOption(String option) throws userWantsRecapException, userWantsToQuitException {

        this.narrator.narrate(option);

        String userInput = this.scanner.nextLine();

        checkForNavigation(userInput);

        while (!validator.validate(option, userInput)) {

            narrator.narrate("Error");
            userInput = scanner.nextLine();

            checkForNavigation(userInput);
        }


        switch (option) {
            case "Character Choice":
                this.creator.setType(Integer.parseInt(userInput));
                this.hero = creator.create();

                this.narrator.setHeroType(this.hero);
                this.validator.setHeroType(this.hero);

                break;
            case "Name":
                this.hero.setName(userInput);
                break;
            case "Life Level":
                this.hero.setLifeLevel(Integer.parseInt(userInput));
                break;
            case "Strength":
                this.hero.setStrength(Integer.parseInt(userInput));
        }


    }

    private void checkForNavigation(String userInput) throws userWantsRecapException, userWantsToQuitException{

        if (validator.validate("Exit", userInput)) {

            narrator.narrate("Exit");
            throw new userWantsToQuitException();

        }

        if (validator.validate("Status", userInput)) {

            narrator.narrate("Status");
            throw new userWantsRecapException();
        }
    }


}
