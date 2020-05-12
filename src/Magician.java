public class Magician{

    private String name;
    private int lifeLevel;
    private int strength;
    private Spell spell;
    private String philter;

    // CONSTRUCTORS ===================================================================================================

    public Magician(){
        name = "Alexis";
        lifeLevel = 4;
        strength = 11;
    }

    public Magician(String name){
        this.name = name;
        lifeLevel = 4;
        strength = 11;
    }

    public Magician(String name, int lifeLevel, int strength){
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String magicianDescription = "Character of type Magician.\nCurrent life level:" +
            lifeLevel + "\nStrength: " + strength;

        if(spell != null) {
            magicianDescription += "\n Spell:\n    -Name: " +
                    spell.getName() + "\n    -Strength: " + spell.getStrength();
        } else {
            magicianDescription += "\nNo spell assigned";
        }

        if(philter != null) {
            magicianDescription += "\nPhilter: " + philter;
        } else {
            magicianDescription += "\nNo philter assigned";
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

    public Spell getSpell(){
        return spell;
    }

    public String getPhilter(){
        return philter;
    }

    // SETTERS ========================================================================================================

    public void setLifeLevel(int lifeLevel){
        this.lifeLevel = lifeLevel;
    }

    public void setSpell(Spell spell){
        this.spell = spell;
    }

    public void setPhilter(String philter){
        this.philter = philter;
    }
}
