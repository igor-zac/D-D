package characters;

import equipments.Spell;
import equipments.Philter;

public class Magician extends Character{

    // CONSTRUCTORS ===================================================================================================

    public Magician(){
        super("", 4, 11);
    }

    public Magician(String name){
        super(name, 4, 11);
    }

    public Magician(String name, int lifeLevel, int strength){
        super(name, lifeLevel, strength);
    }

    // SETTERS ========================================================================================================

    public void setOffensiveEquipment(Spell spell){
        super.setOffensiveEquipment(spell);
    }

    public void setDefensiveEquipment(Philter philter){
        super.setDefensiveEquipment(philter);
    }

}
