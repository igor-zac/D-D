package equipments;

public abstract class OffensiveEquipment extends Equipment{

    protected int strength;

    // CONSTRUCTORS ===================================================================================================

    protected OffensiveEquipment(String type, String name, int strength){
        super(type, name);
        this.strength = strength;
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Name: " + this.name +
                "\nStrength: " + this.strength;

        return description;
    }

    // GETTERS ========================================================================================================

    public int getStrength(){
        return this.strength;
    }

}
