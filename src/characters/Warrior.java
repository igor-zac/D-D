package characters;

import equipments.Weapon;
import equipments.Shield;

public class Warrior extends Character{

    // CONSTRUCTORS ===================================================================================================

    public Warrior(){
        super("", 4, 11);
    }

    public Warrior(String name){
        super(name, 4, 11);
    }

    public Warrior(String name, int lifeLevel, int strength){
        super(name, lifeLevel, strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Weapon weapon){
        super.setOffensiveEquipment(weapon);
    }

    public void setDefensiveEquipment(Shield shield){
        super.setDefensiveEquipment(shield);
    }

}
