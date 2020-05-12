public abstract class Character {

    private String name;
    private int lifeLevel;
    private int strength;

    protected Character(String name, int lifeLevel, int strength) {
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strength = strength;
    }
}
