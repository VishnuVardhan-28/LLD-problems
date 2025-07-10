package Objects;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    int boardSize;

    public Board(int boardSize, int noOfSnakes, int noOfLadders){
        this.boardSize = boardSize;
        initializeBoard();
        addSnakesAndLadders(cells,noOfSnakes,noOfLadders);
    }

    private void initializeBoard() {
        cells = new Cell[boardSize][boardSize];
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void addSnakesAndLadders(Cell[][] cells, int noOfSnakes, int noOfLadders) {
        Set<Integer> usedPositions = new HashSet<>();
        while(noOfSnakes > 0 || noOfLadders > 0){
            int head = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize - 1);
            int tail = ThreadLocalRandom.current().nextInt(1,boardSize*boardSize - 1);
            if(usedPositions.contains(head) || usedPositions.contains(tail) || head == tail){
                continue;
            }
            if(head > tail && noOfSnakes > 0){
                Jump snakeObj = new Jump(head,tail);
                Cell cellObj = getCell(head);
                cellObj.jump = snakeObj;
                noOfSnakes--;
            }
            if(head < tail && noOfLadders > 0){
                Jump ladderObj = new Jump(head,tail);
                Cell cellObj = getCell(head);
                cellObj.jump = ladderObj;
                noOfLadders--;
            }
        }
    }

    Cell getCell(int playerPosition){
        int boardRow = playerPosition/boardSize;
        int boardCol = playerPosition%boardSize;
        return cells[boardRow][boardCol];
    }

}
