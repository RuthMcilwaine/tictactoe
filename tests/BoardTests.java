import org.junit.Assert;
import org.junit.Test;

public class BoardTests {

    // test if place is already taken
    @Test
    public void canTestIfLocationIsEmpty() {
        Board board = new Board();
        boolean isMoveAccepted = board.isMoveAccepted(1,1);
        //test what happens
        Assert.assertTrue(isMoveAccepted);
    }

    @Test
    public void canTestIfLocationIsNotEmpty() {
        Board board = new Board();
        board.setPiece(1,1, "X");
        boolean isMoveAccepted = board.isMoveAccepted(1,1);
        Assert.assertFalse(isMoveAccepted);
    }

    // coordinates are out of bounds
    @Test
    public void canTestIfLocationIsOutOfBoundsMoveInNotAccepted() {
        Board board = new Board();
        boolean isMoveAccepted = board.isMoveAccepted(1,4);
        //test what happens
        Assert.assertFalse(isMoveAccepted);
    }

    //piece placed correctly
    @Test
    public void isPiecePlacedInCorrectLocation() {
        Board board = new Board();
        board.setPiece(1, 1, "X");
        String isPiecePlacedInCorrectLocation = board.retrievePieceAtCoordinates(1,1);

        Assert.assertEquals("X", isPiecePlacedInCorrectLocation);
    }

}


