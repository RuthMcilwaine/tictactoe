import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner input = new Scanner(System.in);


        while (game.checkForWinner() == false) {
            System.out.println("Player 1 choose coordinates:");
            if(game.takeTurn(1, 1) ==true) {
                game.changePlayer();
            }
            System.out.println(game.board.toString());

            System.out.println("Player 2 choose coordinates:");
            if(game.takeTurn(2, 1) ==true) {
                game.changePlayer();
            }
            System.out.println(game.board.toString());

            System.out.println("Player 1 choose coordinates:");
            if(game.takeTurn(1, 2) ==true) {
                game.changePlayer();
            }
            System.out.println(game.board.toString());

            System.out.println("Player 2 choose coordinates:");
            if(game.takeTurn(2, 0) ==true) {
                game.changePlayer();
            }
            System.out.println(game.board.toString());

            System.out.println("Player 1 choose coordinates:");
            if(game.takeTurn(1, 0) ==true) {
                game.changePlayer();
            }
            System.out.println(game.board.toString());
        }
        System.out.println(game.getCurrentPlayer().getPiece() + " is the winner!");
//        System.out.println();

    }
}
