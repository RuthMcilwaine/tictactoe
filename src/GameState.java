public class GameState {
    private String currentBoard;
    private String message;

    public GameState(String currentBoard, String message) {
        this.currentBoard = currentBoard;
        this.message = message;
    }

    public String getCurrentBoard() {
        return currentBoard;
    }

    public String getMessage() {
        return message;
    }
}
