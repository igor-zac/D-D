package equipments;

public class Spell extends OffensiveEquipment{

    // CONSTRUCTORS ===================================================================================================

    public Spell(String name, int strength){
        super("equipments.Spell", name, strength);
    }

    // TO_STRING ======================================================================================================

    public String toString(){
        String description = "Type: equipments.Spell\n" + super.toString();

        return description;
    }
}
