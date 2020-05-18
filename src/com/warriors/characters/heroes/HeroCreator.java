package com.warriors.characters.heroes;

public class HeroCreator {

    private String type;
    private final String[] possibleHeroes = Hero.availableHeroes;


    /**
     * Default constructor
     */
    public HeroCreator() {
        this(0);
    }

    /**
     *
     * @param typeIndex
     */
    public HeroCreator(int typeIndex) {
        this.setType(typeIndex);
    }

    /**
     *
     * @return Hero hero
     */
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

    /**
     *
     * @param typeIndex
     */
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
