public class Spell {

    private String name;
    private int strength;

    // CONSTRUCTORS ===================================================================================================

    public Spell(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String spellDescription = "Weapon's name: " + name +
                "\nStrength: " + strength;

        return spellDescription;
    }

    // GETTERS ========================================================================================================

    public String getName(){
        return name;
    }

    public int getStrength(){
        return strength;
    }
}
