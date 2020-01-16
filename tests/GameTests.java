import org.junit.Assert;
import org.junit.Test;

public class GameTests {

    @Test
    public void firstPlayerIsX() {
        Game game = new Game();
        GameState currentState = game.getGameState();
        Assert.assertEquals("New Game. Player X take your turn!", currentState.getMessage());
    }

    @Test
    public void canChoosePlayersPiece() {
        Game game = new Game(new Player(" L "), new Player(" O "));
        GameState currentState = game.getGameState();
        Assert.assertEquals("New Game. Player L take your turn!", currentState.getMessage());
    }

    @Test
    public void playerCanTakeTurn() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","0"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Success! Player  O  take your turn!", currentState.getMessage());
    }


    @Test
    public void changesAfterPlayer2TakeTurn() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"1","0"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Success! Player  X  take your turn!", currentState.getMessage());
    }

    @Test
    public void player1CanWinHorizontally() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","0"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"0","2"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Player X wins", currentState.getMessage());
        Assert.assertTrue(game.checkForWinner());
    }

    @Test
    public void player2CanWinHorizontally() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"0","2"});
        game.playersMove(new String[]{"2","1"});
        game.playersMove(new String[]{"0","0"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Player O wins", currentState.getMessage());
        Assert.assertTrue(game.checkForWinner());
    }

    @Test
    public void player1CanWinVertically() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","0"});
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"0","2"});
        game.playersMove(new String[]{"2","0"});
        GameState currentState = game.getGameState();
        Assert.assertTrue(game.checkForWinner());
        Assert.assertEquals("Player X wins", currentState.getMessage());
    }

    @Test
    public void player2CanWinVertically() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"1","1"});
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"0","2"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"0","0"});
        GameState currentState = game.getGameState();
        Assert.assertTrue(game.checkForWinner());
        Assert.assertEquals("Player O wins", currentState.getMessage());
    }


    @Test
    public void player1CanWinDiagonally() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","0"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"1","1"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"2","2"});
        GameState currentState = game.getGameState();
        Assert.assertTrue(game.checkForWinner());
        Assert.assertEquals("Player X wins", currentState.getMessage());
    }

    @Test
    public void player2CanWinDiagonally() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"2","2"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"1","1"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"0","0"});
        GameState currentState = game.getGameState();
        Assert.assertTrue(game.checkForWinner());
        Assert.assertEquals("Player O wins", currentState.getMessage());
    }

    @Test
    public void playerDoesNotChangeAfterInvalidMove() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"0","1"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Invalid Move. Try again!", currentState.getMessage());
    }

    @Test
    public void gameDrawsIf() {
        Game game = new Game(new Player(" X "), new Player(" O "));
        game.playersMove(new String[]{"0","1"});
        game.playersMove(new String[]{"1","0"});
        game.playersMove(new String[]{"2","2"});
        game.playersMove(new String[]{"1","1"});
        game.playersMove(new String[]{"2","0"});
        game.playersMove(new String[]{"0","2"});
        game.playersMove(new String[]{"1","2"});
        game.playersMove(new String[]{"0","0"});
        game.playersMove(new String[]{"2","1"});
        GameState currentState = game.getGameState();
        Assert.assertEquals("Draw", currentState.getMessage());
    }

}
