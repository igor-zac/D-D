package com.warriors.characterCreation;

import com.warriors.characters.heroes.Hero;
import com.warriors.characters.heroes.HeroCreator;

public class InputValidator {

    private Hero hero;

    final private String[] confirmOptions = {"y", "yes"};
    final private String[] declineOptions = {"n", "no"};
    final private String[] exitOptions = {"q", "quit", "exit"};
    final private String[] displayOptions = {"show"};


    /**
     *
     * @param optionToValidate
     * @param userInput
     * @return boolean isValid
     */
    public boolean validate(String optionToValidate, String userInput) {
        boolean isInputValid = false;
        userInput = userInput.toLowerCase();

        switch (optionToValidate) {
            case "Character Choice":

                isInputValid = this.validateHeroType(userInput);
                break;

            case "Name":

                isInputValid = this.validateName(userInput);
                break;

            case "Life Level":

                isInputValid = this.validateLifeLevel(userInput);
                break;

            case "Strength":

                isInputValid = this.validateStrength(userInput);
                break;

            case "Status":

                isInputValid = this.validateStatus(userInput);
                break;

            case "Confirm":

                isInputValid = this.validateConfirm(userInput);
                break;

            case "Decline":

                isInputValid = this.validateDecline(userInput);
                break;

            case "Exit":

                isInputValid = this.validateExit(userInput);
                break;

        }

        return isInputValid;
    }

    /**
     *
     * @param hero
     */
    public void setHeroType(Hero hero){
        this.hero = hero;
    }

    private boolean validateHeroType(String heroIndex) {

        String heroType;
        int index;

        try {

            index = Integer.parseInt(heroIndex) - 1;

        } catch (NumberFormatException nfe) {

            return false;

        }

        if(index >= 0  && index < Hero.availableHeroes.length){

            HeroCreator cr = new HeroCreator(index);
            hero = cr.create();

            return true;
        } else {

            return false;
        }

    }

    private boolean validateName(String name) {
        if (name != null && name != "") {
            return true;
        }

        return false;
    }

    private boolean validateLifeLevel(String lifelevel) {
        try {
            int choice = Integer.parseInt(lifelevel);

            if (choice >= this.hero.getLifeMin() && choice <= this.hero.getLifeMax()){
                return true;
            }

            return false;

        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    private boolean validateStrength(String strength) {
        try {
            int choice = Integer.parseInt(strength);

            if(choice >= hero.getStrengthMin() && choice <= hero.getStrengthMax()){
                return true;
            }

            return false;

        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean validateConfirm(String userInput){
        for (String possibleChoice : confirmOptions) {
            if (possibleChoice.equals(userInput)) {
                return true;
            }
        }

        return false;
    }

    private boolean validateDecline(String userInput){
        for (String possibleChoice : declineOptions) {

            if (possibleChoice.equals(userInput)) {
                return true;
            }
        }

        return false;
    }

    private boolean validateExit(String userInput){
        for (String option : exitOptions) {
            if (userInput.equals(option)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateStatus(String userInput){
        for (String option : displayOptions) {
            if (userInput.equals(option)) {
                return true;
            }
        }

        return false;
    }
}
