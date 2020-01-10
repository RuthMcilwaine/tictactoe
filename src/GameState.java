public class GameState {
    private String currentBoard;
    private String piece;
    private String message;

    public GameState(String currentBoard, String piece, String message) {
        this.currentBoard = currentBoard;
        this.piece = piece;
        this.message = message;
    }

    public String getCurrentBoard() {
        return currentBoard;
    }

    public String getPiece() {
        return piece;
    }

    public String getMessage() {
        return message;
    }
}
