package com.warriors.board;

import com.warriors.characters.enemies.*;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    public final int NB_OF_SPACES = 64;
    private HashMap<Integer, Space> track = new HashMap<Integer, Space>();

    private final int[] dragonSpaces = {45, 52, 56, 62};
    private final int[] sorcererSpaces = {10, 20, 25, 32, 35, 36, 37, 40, 44, 47};
    private final int[] goblinSpaces = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};

    private final int[] maces = {2, 11, 5, 22, 38};
    private final int[] swords = {19, 26, 42, 53};
    private final int[] thunderbolts = {1, 4, 8, 17, 23};
    private final int[] fireballs = {48, 49};
    private final int[] stdPotions = {7, 13, 31, 33, 39, 43};
    private final int[] bigPotions = {28, 41};


    private Map<String, int[]> enemies = new HashMap<String, int[]>() {
        {
            put("dragon", dragonSpaces);
            put("sorcerer", sorcererSpaces);
            put("goblin", goblinSpaces);
        }
    };

    private Map<String, int[]> items = new HashMap<String, int[]>() {
        {
            put("mace", maces);
            put("sword", swords);
            put("thunderbolt", thunderbolts);
            put("fireball", fireballs);
            put("stdPotion", stdPotions);
            put("bigPotion", bigPotions);
        }
    };


    public GameBoard() {
        setupSpaces();
        setupEnemies();
        setupItems();
    }

    private void setupSpaces() {
        for (int i = 1; i <= this.NB_OF_SPACES; i++) {
            Space space = new Space();
            track.put(i, space);
        }
    }

    private void setupEnemies() {
        EnemyCreator enemyCreator = new EnemyCreator();

        for (String enemyType : enemies.keySet()) {

            enemyCreator.setType(enemyType);

            for (int space : enemies.get(enemyType)) {

                Enemy enemy = enemyCreator.create();
                track.get(space).setEnemy(enemy);

            }
        }
    }

    private void setupItems() {
        for (String item : items.keySet()) {
            String itemType = "";

            switch (item) {
                case "mace":
                    itemType = item;
                    break;
                case "sword":
                    itemType = item;
                    break;
                case "thunderbolt":
                    itemType = item;
                    break;
                case "fireball":
                    itemType = item;
                    break;
                case "stdPotion":
                    itemType = item;
                    break;
                case "bigPotion":
                    itemType = item;
                    break;
            }

            for (int space : items.get(item)) {
                track.get(space).setItem(itemType);
            }
        }
    }

    public Space getCurrentSpace(int currentSpace) {
        return this.track.get(currentSpace);
    }

}
