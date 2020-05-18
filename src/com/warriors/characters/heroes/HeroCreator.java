package com.warriors.characters.heroes;

public class HeroCreator {

    private String type;
    private final String[] possibleHeroes = Hero.availableHeroes;


    public HeroCreator() {
        this(0);
    }

    public HeroCreator(int typeIndex) {
        this.setType(typeIndex);
    }

    public Hero create() {
        Hero hero;

        switch (this.type) {
            case "Warrior":
                hero = createWarrior();
                break;
            case "Magician":
                hero = createMagician();
                break;
            default:
                hero = createWarrior();
                break;
        }

        return hero;
    }

    public Hero create(String name, int lifeLevel, int strength) {
        Hero hero;

        switch (this.type) {
            case "Warrior":
                hero = createWarrior();
                break;
            case "Magician":
                hero = createMagician();
                break;
            default:
                hero = createWarrior();
                break;
        }

        hero.setName(name);
        hero.setLifeLevel(lifeLevel);
        hero.setStrength(strength);

        return hero;
    }

    public void setType(int typeIndex) {
        if(typeIndex >= 0 && typeIndex < possibleHeroes.length){
            this.type = possibleHeroes[typeIndex];
        } else {
            this.type = possibleHeroes[0];
        }
    }

    private Magician createMagician() {
        return new Magician();
    }

    private Warrior createWarrior() {
        return new Warrior();
    }
}
