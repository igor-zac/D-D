package com.warriors.game.board;

import com.warriors.characters.enemies.*;

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
            put("items", new HashMap<String, Integer>(){
                {
                    put("mace", 5);
                    put("sword", 4);
                    put("thunderbolt", 5);
                    put("fireball", 2);
                    put("stdPotion", 6);
                    put("bigPotion", 2);
                }
            });
        }
    };


    public GameBoard() {
        setupSpaces();
        setupEnemies();
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

    private void setupItems() {
        for (String item : this.boardContent.get("items").keySet()) {

            Space space;
            int nbToSetup = 0;
            Random rand = new Random();

            while(nbToSetup < this.boardContent.get("items").get(item)){

                space = track.get(rand.nextInt(track.size()));

                if(space.isEmpty()) {
                    space.setItem(item);
                    nbToSetup++;
                }

            }

        }
    }

    public Space getCurrentSpace(int currentSpace) {
        return this.track.get(currentSpace);
    }

}
