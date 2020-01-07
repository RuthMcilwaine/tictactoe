import org.junit.Assert;
import org.junit.Test;

public class GameTests {

    @Test
    public void firstPlayerIsX() {
        Game game = new Game();
        Player currentPlayer = game.getCurrentPlayer();
        Assert.assertEquals("X", currentPlayer.getPiece());

    }

    @Test
    public void playerCanTakeTurn() {
        Game game = new Game();
        Boolean result = game.takeTurn(2, 1);
        Player currentPlayer = game.getCurrentPlayer();
        Assert.assertEquals("O", currentPlayer.getPiece());
        Assert.assertTrue(result);
    }

    @Test
    public void changesAfterPlayer2TakeTurn() {
        Game game = new Game();
        game.takeTurn(2, 1);
        game.takeTurn(1, 1);
        Player currentPlayer = game.getCurrentPlayer();
        Assert.assertEquals("X", currentPlayer.getPiece());
    }


    // Make Game
    // Game: Take Turn (PLayer 1, coordinates)
    // Take Turn Player
    // display board (represent the players as a string)
    // determine if someone won


}