package com.warriors.characterCreation;

import com.warriors.characters.heroes.Hero;
import com.warriors.characters.heroes.HeroCreator;
import com.warriors.customExceptions.UserWantsRecapException;
import com.warriors.customExceptions.UserWantsToQuitException;

import java.util.Scanner;

public class CharacterCreationHandler {

    private final Scanner scanner;
    private final CLICreationNarrator narrator;
    private final InputValidator validator;
    private final HeroCreator creator;

    private Hero hero;
    private boolean finishedCreating = false;

    final private String[] characterOptions = {"Character Choice", "Name", "Life Level", "Strength"};


    /**
     * Default constructor
     */
    public CharacterCreationHandler() {
        this.scanner = new Scanner(System.in);
        this.narrator = new CLICreationNarrator();
        this.validator = new InputValidator();
        this.creator = new HeroCreator();
    }

    /**
     *
     * @return createdHero
     * @throws UserWantsToQuitException
     */
    public Hero registerCharacter() throws UserWantsToQuitException {

        this.narrator.narrate("Welcome");

        while (!finishedCreating) {

            this.narrator.narrate("NavigationInfo");

            for (int i = 0; i < characterOptions.length; i++) {
                try {
                    setupCharacterOption(characterOptions[i]);
                } catch (UserWantsRecapException uWRE) {
                    i--;
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

    private void setupCharacterOption(String option) throws UserWantsRecapException, UserWantsToQuitException {

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
                this.creator.setType(Integer.parseInt(userInput)-1);
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

    private void checkForNavigation(String userInput) throws UserWantsRecapException, UserWantsToQuitException {

        if (validator.validate("Exit", userInput)) {

            narrator.narrate("Exit");
            throw new UserWantsToQuitException();

        }

        if (validator.validate("Status", userInput)) {

            narrator.narrate("Status");
            throw new UserWantsRecapException();
        }
    }


}
