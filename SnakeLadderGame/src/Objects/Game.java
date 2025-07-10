package Objects;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10,5,5);
        dice = new Dice(1);
        addPlayers();
        winner = null;
    }

    private void addPlayers() {
        Player p1 = new Player("Vishnu");
        Player p2 = new Player("Naveen");
        playerList.add(p1);
        playerList.add(p2);
    }

    public void startGame() {
        while(winner == null){
            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.pname + " current position is: " + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerTurn.currentPosition = jumpCheck(playerNewPosition, playerTurn.pname);
            System.out.println("player turn is:" + playerTurn.pname + " new Position is: " + playerTurn.currentPosition);

            //check for winning condition
            if(playerTurn.currentPosition >= board.boardSize* board.boardSize - 1){
                winner = playerTurn;
            }
        }
        System.out.println("*******Congratulations, " + winner.pname + " won the game. ***********");
    }

    private int jumpCheck(int playerNewPosition, String pname) {
        if(playerNewPosition >= board.boardSize* board.boardSize - 1){
            return playerNewPosition;
        }
        Cell cellobj = board.getCell(playerNewPosition);
        if(cellobj.jump != null && cellobj.jump.start == playerNewPosition){
            String jumpBy = (cellobj.jump.start < cellobj.jump.end) ? "Ladder" : "Snake";
            System.out.println("At position " + playerNewPosition + " " + pname + " got hit by " + jumpBy);
            return cellobj.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurn = playerList.removeFirst();
        playerList.addLast(playerTurn);
        return playerTurn;
    }
}
