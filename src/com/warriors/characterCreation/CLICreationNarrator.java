package com.warriors.characterCreation;

import com.warriors.characters.heroes.Hero;

public class CLICreationNarrator {

    private Hero hero;

    /**
     *
     * @param partToTell
     */
    public void narrate(String partToTell) {

        System.out.println();

        switch (partToTell) {
            case "Character Choice":

                this.narrateCharacterChoice();
                break;

            case "Name":

                this.narrateName();
                break;

            case "Life Level":

                this.narrateLifeLevel();
                break;

            case "Strength":

                this.narrateStrength();
                break;

            case "Exit":

                this.narrateExit();
                break;

            case "Error":

                this.narrateError(true);
                break;

            case "TinyError":

                this.narrateError(false);
                break;

            case "Welcome":

                this.narrateWelcome();
                break;

            case "NavigationInfo":

                this.narrateNavigationInfo();
                break;

            case "Status":

                this.displayStatus();
                break;

            case "Recap":

                this.narrateRecap();
                break;

        }
    }

    public void setHeroType(Hero hero) {
        this.hero = hero;
    }

    private void narrateCharacterChoice() {
        System.out.println("Are you:\n");
        for (int i = 1; i <= Hero.availableHeroes.length; i++) {
            System.out.println(i + " - A " + Hero.availableHeroes[i - 1]);
        }
        System.out.println("\n(enter the number corresponding to your choice)\n");
    }

    private void narrateName() {
        System.out.println("What is your name?");
    }

    private void narrateLifeLevel() {
        System.out.println("What is your current life level?\nAnd don't try to fool me, I know you are a "
                + this.hero.getClass().getSimpleName() + ", so it must be between " + this.hero.getLifeMin()
                + " and " + this.hero.getLifeMax() + "!");
    }

    private void narrateStrength() {
        System.out.println("What is your strength?\nAgain, don't lie to me, it must be between "
                + this.hero.getStrengthMin() + " and " + this.hero.getStrengthMax() + ".");
    }

    private void narrateExit() {
        System.out.println("I see you do not want to continue...\n\n");
    }

    private void narrateError(Boolean fullMessage) {
        System.out.print("I did not understand");
        if (fullMessage) {
            System.out.print(" or the input is incorrect, could you repeat please?");
        } else {
            System.out.print(".");
        }

        System.out.println();
    }

    private void narrateWelcome() {
        System.out.println("I'm going to need some information so we can get started on our adventure!\n" +
                "\nSo, tell me about yourself adventurer.");
    }

    private void narrateNavigationInfo() {
        System.out.println("Keep in mind that you can quit at any moment, just enter 'q', 'quit' or 'exit'.\n" +
                "And if you want to check the current status of your character, just type 'show'.");
    }

    private void displayStatus() {
        System.out.println("\nYour current status :\n(don't worry you will be able to make changes at the end)\n");

        this.displayCharacterInfo();
    }

    private void narrateRecap() {
        System.out.println("Here is what I know about you :");

        this.displayCharacterInfo();
    }

    private void displayCharacterInfo() {
        if (this.hero == null) {
            System.out.println("Nothing so far...");
        } else {
            System.out.println("Character Choice - " + this.hero.getClass().getSimpleName()
                    + "\nName : " + this.hero.getName()
                    + "\nLife level : " + this.hero.getLifeLevel()
                    + "\nStrength : " + this.hero.getStrength());
        }
    }
}
