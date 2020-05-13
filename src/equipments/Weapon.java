package equipments;

public class Weapon extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    public Weapon(String name, int strength){
        super("equipments.Weapon", name, strength);
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Type: equipments.Weapon\n" + super.toString();

        return description;
    }
}
