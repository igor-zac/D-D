package com.warriors;


public class Main {

    public static void main(String[] args){
        Main game = new Main();

        game.start();

        Menu menu = new Menu();
        menu.startGame();
//        menu.startGame();

        game.stop();
    }

    private void start(){
        String welcomingMsg = "Welcome to Dungeons and Dragons adventurer!\n";

        System.out.println("Welcome to Dungeons and Dragons adventurer!\n");
    }

    private void stop(){
        String goodbyeMsg = "It was nice having you here. Farewell adventurer, and may destiny always walk by your side...";

        System.out.println(goodbyeMsg);
    }

}
