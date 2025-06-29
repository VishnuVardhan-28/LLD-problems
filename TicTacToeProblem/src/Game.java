import model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Deque<Player> players;
    private Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX(PieceType.X);
        Player player1 = new Player(crossPiece,"Player1");
        PlayingPieceO noughtPiece = new PlayingPieceO(PieceType.O);
        Player player2 = new Player(noughtPiece, "Player2");
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while(noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBboard();
            boolean freeSpace = gameBoard.getFreeCells();
            if(freeSpace == false){
                noWinner = false;
                continue;
            }
            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn,playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = gameBoard.isThereWinner(inputRow,inputColumn, playerTurn.getPlayingPiece().getPieceType());

            if(winner){
                return playerTurn.getName();
            }

        }
        return "tie";
    }


}
