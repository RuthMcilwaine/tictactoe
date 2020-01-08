import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] CoordinatesSplit = userInput.split(",");


        while (!game.checkForWinner()) {
            System.out.println(game.board.toString());
            System.out.println("Player " + game.getCurrentPlayer().getPiece() + " choose coordinates:");
            game.playersMove(CoordinatesSplit);
        }
        System.out.println("Player " + game.getCurrentPlayer().getPiece() + " is the winner!");
    }
}