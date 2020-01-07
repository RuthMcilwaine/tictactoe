import java.util.Scanner;

public class Game {

    Board board = new Board();
    Player player1 = new Player(" X ");
    Player player2 = new Player(" O ");
    Player currentPlayer;


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }


    public Boolean takeTurn(int row, int column) {
        if (board.isMoveAccepted(row, column)) {
            board.setPiece(row, column, currentPlayer);
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkForWinner() {
        if (board.checkRow() == true) {
            return true;
//            if (checkColumn() == true)
//                if (checkDiagonal() == true) ;
    }
        return false;
    }




    public Game() {
        currentPlayer = player1;

    }


}

