public class Weapon {

    private String name;
    private int strength;

    // CONSTRUCTORS ===================================================================================================

    public Weapon(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String weaponDescription = "Weapon's name: " + name +
                "\nStrength: " + strength;

        return weaponDescription;
    }

    // GETTERS ========================================================================================================

    public String getName(){
        return name;
    }

    public int getStrength(){
        return strength;
    }
}
