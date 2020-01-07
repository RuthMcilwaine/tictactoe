import org.junit.Assert;
import org.junit.Test;

import java.util.logging.XMLFormatter;

public class BoardTests {

    // test if place is already taken
    @Test
    public void canTestIfLocationIsEmpty() {
        Board board = new Board();
        boolean isMoveAccepted = board.isMoveAccepted(1,1);
        //test what happens
        Assert.assertEquals(isMoveAccepted, true);
    }

    @Test
    public void canTestIfLocationIsNotEmpty() {
        Board board = new Board();
        Player player = new Player("X");
        board.setPiece(1,1, player);
        boolean isMoveAccepted = board.isMoveAccepted(1,1);
        Assert.assertEquals(isMoveAccepted, false);
    }

    // coordinates are out of bounds
    @Test
    public void canTestIfLocationIsOutOfBoundsMoveInNotAccepted() {
        Board board = new Board();
        boolean isMoveAccepted = board.isMoveAccepted(1,4);
        //test what happens
        Assert.assertEquals(isMoveAccepted, false);
    }

    //piece placed correctly
    @Test
    public void isPiecePlacedInCorrectLocation() {
        Board board = new Board();
        Player player = new Player("X");
        board.setPiece(1, 1, player);
        String isPiecePlacedInCorrectLocation = board.retrievePieceAtCoordinates(1,1);

        Assert.assertEquals("X", isPiecePlacedInCorrectLocation);
    }

}


