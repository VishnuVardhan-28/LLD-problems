public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing the game.......!");
        Game game = new Game();
        game.initializeGame();
        System.out.println("The winner of the game is : " + game.startGame());
    }
}