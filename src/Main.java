import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        while (!game.checkForWinner()) {
            GameState gameState = game.getGameState();
            System.out.println("Board: " + gameState.getCurrentBoard());
            System.out.println("Message: " + gameState.getMessage());
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            String[] coordinatesSplit = userInput.split(",");
            game.playersMove(coordinatesSplit);
        }
        System.out.println("Player " + game.getGameState() + " is the winner!");
    }
}