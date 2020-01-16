
public class Game {

    private Board board = new Board();
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState gameState;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameState = new GameState(board.toString(), "New Game. Player" + currentPlayer.getPiece() + "take your turn!");
    }

    public Game() {
        this(new Player(" X "),new Player(" O "));
    }

    public Boolean checkForWinner() {
        if (board.checkRow()) {
            return true;
        }
        if (board.checkColumn()) {
            return true;
        }
        if (board.checkDiagonal()) {
            return true;
        }
        return false;
    }

    public void playersMove(String[] CoordinatesSplit) {
        if (!takeTurn(CoordinatesSplit[0], CoordinatesSplit[1])) {
            gameState = new GameState(board.toString(), "Invalid Move. Try again!");
            return;
        }

        if (checkForWinner()) {
            gameState = new GameState(board.toString(), "Player" + currentPlayer.getPiece() + "wins");
            return;
        }
        if (checkForDraw()){
            gameState = new GameState(board.toString(),  "Draw");
                return;
        }
        else {
            changePlayer();
            gameState = new GameState(board.toString(), "Success! Player " + currentPlayer.getPiece() + " take your turn!");
        }
    }

    private Boolean checkForDraw() {
        return board.isFull();
    }

    public Boolean takeTurn(String rows, String columns) {
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);
        if (board.isMoveAccepted(row, column)) {
            board.setPiece(row, column, currentPlayer.getPiece());
            return true;
        } else {
            return false;
        }
    }

    private void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}

