import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        while (!game.checkForWinner()) {
            System.out.println(game.board.toString());
            System.out.println("Player " + game.getCurrentPlayer().getPiece() + ", please enter your coordinates:");
            game.playersMove(game.CoordinatesSplit);
        }
        System.out.println("Player " + game.getCurrentPlayer().getPiece() + " is the winner!");
    }
}