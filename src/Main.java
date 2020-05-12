public class Main {

    private boolean playing = true;

    public static void main(String[] args){
        gameStart();
        Menu.createCharacter();
        Menu.startGame();
        gameEnd();
    }

    private static void gameStart(){
        String welcomingMsg = "Welcome to Dungeons and Dragons adventurer!\n";

        System.out.println(welcomingMsg);
    }

    private static void gameEnd(){
        String goodbyeMsg = "It was nice having you here. Farewell adventurer, and may destiny always walk by your side...";

        System.out.println(goodbyeMsg);
    }
}
