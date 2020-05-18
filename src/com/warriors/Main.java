package com.warriors;


public class Main {

    public static boolean DEBUG = false;
    public static String debugFileName = "";


    /**
     *
     * @param args
     */
    public static void main(String[] args){
        if(args != null && args.length>0) {
            initDebug(args);
        }

        System.out.println();

        Main game = new Main();

        game.start();

        Menu menu = new Menu();
        menu.start();
//        menu.startGame();

        game.stop();
    }


    private static void initDebug(String[] args){
        if (args[0].equals("debug")){
            if (args.length == 2) {
                Main.DEBUG = true;
                Main.debugFileName = args[1];
                System.out.println("Debug type - automatic");
            } else {
                System.out.println("Incorrect number of arguments provided.");
            }
        } else {
            System.out.println("Incorrect argument : " + args[0]);
        }

        System.out.println("\n\n");
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
