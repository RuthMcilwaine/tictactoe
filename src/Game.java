import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Player player1 = new Player(" X ");
    private Player player2 = new Player(" O ");
    private Player currentPlayer = player1;
    private GameState gameState = new GameState(board.toString(), currentPlayer.getPiece(), "New Game !");


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
                gameState = new GameState(board.toString(), currentPlayer.getPiece(), "Success! Next turn!");

            }
        }else {
            gameState = new GameState(board.toString(), currentPlayer.getPiece(), "Invalid Move");
        }
    }

//    public String displayBoard() {
//        return board.toString();
//    }

    private Boolean takeTurn(String rows, String columns) {
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);
        if (board.isMoveAccepted(row, column)) {
            board.setPiece(row, column, currentPlayer);
            return true;
        } else {
            return false;
        }
    }

    private void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
/*

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
*/

    public Game() {
        currentPlayer = player1;
    }

    public GameState getGameState() {
        return gameState;
    }
}

