package com.warriors.game.board;

import com.warriors.characters.enemies.*;
import com.warriors.items.consumables.Consumable;
import com.warriors.items.consumables.ConsumableCreator;
import com.warriors.items.equipments.EquipmentCreator;
import com.warriors.items.equipments.offense.OffensiveEquipment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameBoard {

    public final int NB_OF_SPACES = 64;
    private HashMap<Integer, Space> track = new HashMap<Integer, Space>();

    private Map<String, Map<String, Integer>> boardContent = new HashMap<String, Map<String, Integer>>(){
        {
            put("enemies", new HashMap<String, Integer>(){
                {
                    put("dragon", 4);
                    put("sorcerer", 10);
                    put("goblin", 10);
                }
            });
            put("equipment", new HashMap<String, Integer>(){
                {
                    put("mace", 5);
                    put("sword", 4);
                    put("thunderbolt", 5);
                    put("fireball", 2);
                }
            });
            put("items", new HashMap<String, Integer>(){
                {
                    put("stdPotion", 6);
                    put("bigPotion", 2);
                }
            });
        }
    };


    /**
     * Default constructor
     */
    public GameBoard() {
        setupSpaces();
        setupEnemies();
        setupEquipment();
        setupItems();

    }

    private void setupSpaces() {
        for (int i = 0; i < this.NB_OF_SPACES; i++) {
            Space space = new Space();
            track.put(i, space);
        }

    }

    private void setupEnemies() {
        EnemyCreator enemyCreator = new EnemyCreator();

        for (String enemyType : this.boardContent.get("enemies").keySet()) {

            enemyCreator.setType(enemyType);
            Space space;
            int nbToSetup = 0;
            Random rand = new Random();

            while (nbToSetup < this.boardContent.get("enemies").get(enemyType)) {

                space = track.get(rand.nextInt(track.size()));
                if(space.isEmpty()) {
                    Enemy enemy = enemyCreator.create();
                    space.setEnemy(enemy);
                    nbToSetup++;
                }
            }
        }
    }

    private void setupEquipment() {
        EquipmentCreator equipmentCreator = new EquipmentCreator();

        for (String equipment : this.boardContent.get("equipment").keySet()) {

            equipmentCreator.setType(equipment);
            Space space;
            int nbToSetup = 0;
            Random rand = new Random();

            while(nbToSetup < this.boardContent.get("equipment").get(equipment)){

                space = track.get(rand.nextInt(track.size()));

                if(space.isEmpty()) {
                    OffensiveEquipment OE = equipmentCreator.create();
                    space.setEquipment(OE);
                    nbToSetup++;
                }

            }

        }
    }

    private void setupItems(){
        ConsumableCreator consCreator = new ConsumableCreator();

        for (String item : this.boardContent.get("items").keySet()) {

            consCreator.setType(item);
            Space space;
            int nbToSetup = 0;
            Random rand = new Random();

            while(nbToSetup < this.boardContent.get("items").get(item)){

                space = track.get(rand.nextInt(track.size()));

                if(space.isEmpty()) {

                    Consumable consumable = consCreator.create();
                    space.setItem(consumable);
                    nbToSetup++;
                }

            }

        }
    }

    /**
     *
     * @param currentSpace
     * @return Space currentSpace
     */
    public Space getCurrentSpace(int currentSpace) {
        return this.track.get(currentSpace);
    }

}
