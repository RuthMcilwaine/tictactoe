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
        Boolean result = game.takeTurn("2", "1");
        Player currentPlayer = game.getCurrentPlayer();
        Assert.assertEquals("O", currentPlayer.getPiece());
        Assert.assertTrue(result);
    }

    @Test
    public void changesAfterPlayer2TakeTurn() {
        Game game = new Game();
        game.takeTurn("2", "1");
        game.takeTurn("1", "1");
        Player currentPlayer = game.getCurrentPlayer();
        Assert.assertEquals("X", currentPlayer.getPiece());
    }


    @Test
    public void showsWinnerIf3PiecesAreInARow() {
        Game game = new Game();
        game.takeTurn("0", "0");
        game.takeTurn("0", "1");
        game.takeTurn("0", "2");
        Assert.assertTrue(game.checkForWinner());

    }

    @Test
    public void showsWinnerIf3PiecesAreHorizontal() {
        Game game = new Game();
        game.takeTurn("0", "0");
        game.takeTurn("1", "0");
        game.takeTurn("2", "0");
        Assert.assertTrue(game.checkForWinner());

    }

    @Test
    public void showsWinnerIf3PiecesAreDiagonal() {
        Game game = new Game();
        game.takeTurn("0", "0");
        game.takeTurn("1", "1");
        game.takeTurn("2", "2");
        Assert.assertTrue(game.checkForWinner());

    }
}
