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


    public Boolean takeTurn(String rows, String columns) {
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);
        if (board.isMoveAccepted(row, column)) {
            board.setPiece(row, column, currentPlayer);
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkForWinner() {
        if (board.checkRow()) {
            return true;
        }
        if (board.checkColumn()) {
            return true;
        }
        if (board.checkDiagonal()) {
            return true;
        }
        return false;
    }

    public void playersMove(String[] CoordinatesSplit) {
        if (takeTurn(CoordinatesSplit[0], CoordinatesSplit[1])) {
            if (!checkForWinner()) {
                changePlayer();
            }
        }
    }


    public Game() {
        currentPlayer = player1;
    }
}

