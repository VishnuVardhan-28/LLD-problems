package model;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void printBboard() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] != null){
                    System.out.print(board[i][j].getPieceType().name()+ "  ");
                }
                else{
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public boolean getFreeCells() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addPiece(int inputRow, int inputColumn, PlayingPiece playingPiece) {
        if(inputRow >= size || inputColumn >= size) return false;
        if(board[inputRow][inputColumn] != null){
            return false;
        }
        board[inputRow][inputColumn] = playingPiece;
        return true;
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatched = true;
        boolean colMatched = true;
        boolean diagonalMatched = true;
        boolean antiDiagonalMatched = true;

        for(int i=0; i<size; i++){
            if(board[row][i] == null || board[row][i].getPieceType() != pieceType){
                rowMatched = false;
            }
        }
        for(int i=0; i<size; i++){
            if(board[i][col] == null || board[i][col].getPieceType() != pieceType){
                colMatched = false;
            }
        }
        for(int i=0, j=0; i<size; i++,j++){
            if(board[i][j] == null || board[i][j].getPieceType() != pieceType){
                diagonalMatched = false;
            }
        }
        for(int i=0, j=size-1; i<size; i++,j--){
            if(board[i][j] == null || board[i][j].getPieceType() != pieceType){
                antiDiagonalMatched = false;
            }
        }

        return rowMatched || colMatched || diagonalMatched || antiDiagonalMatched;
    }

    public int getSize() {
        return size;
    }
}
