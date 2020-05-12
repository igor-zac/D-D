public class Warrior{

    private String name;
    private int lifeLevel;
    private int strength;
    private Weapon weapon;
    private String shield;

    // CONSTRUCTORS ===================================================================================================

    public Warrior(){
        name = "Alexis";
        lifeLevel = 7;
        strength = 7;
    }

    public Warrior(String name){
        this.name = name;
        lifeLevel = 7;
        strength = 7;
    }

    public Warrior(String name, int lifeLevel, int strength){
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String magicianDescription = "Character of type Warrior.\nCurrent life level:" +
                lifeLevel + "\nStrength: " + strength;

        if(weapon != null) {
            magicianDescription += "\n Weapon:\n    -Name: " +
                    weapon.getName() + "\n    -Strength: " + weapon.getStrength();
        } else {
            magicianDescription += "\nNo weapon assigned";
        }

        if(shield != null) {
            magicianDescription += "\nShield: " + shield;
        } else {
            magicianDescription += "\nNo shield assigned";
        }

        return magicianDescription;
    }

    // GETTERS ========================================================================================================

    public String getName(){
        return name;
    }

    public int getLifeLevel(){
        return lifeLevel;
    }

    public int getStrength(){
        return strength;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public String getShield(){
        return shield;
    }

    // SETTERS ========================================================================================================

    public void setLifeLevel(int lifeLevel){
        this.lifeLevel = lifeLevel;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setShield(String shield){
        this.shield = shield;
    }
}
