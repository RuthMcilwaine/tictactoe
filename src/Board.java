public class Board {
    private int width = 3;
    private int height = 3;
    private String[][] board;


    public String retrievePieceAtCoordinates(int row, int column) {
        return board[row][column];
    }


    public Board() {
        // initialises the matrix
        board = new String[width][height];
        // initial state of board
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {
                board[r][c] = r + "," + c;
            }
        }
    }

    public void setPiece(int row, int column, Player player) {
        board[row][column] = player.getPiece();
    }

    private boolean isOutOfBounds(int row, int column) {
        return row > board.length || column > board.length;
    }

    private boolean isLocationEmpty(int row, int column) {
        return ( !board[row][column].equals("X") && !board[row][column].equals("O") );
    }

    public boolean isMoveAccepted(int row, int column) {
        if (!isOutOfBounds(row, column) && isLocationEmpty(row, column)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRow() {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][0] == board[r][2]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn() {
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[0][c] == board[2][c]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal() {
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {

                if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                    return true;
                }
                if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String boardString = "Current board\n";

        for (int r = 0; r < width; r++) {
            boardString += "| ";
            for (int c = 0; c < height; c++) {
                String s = board[r][c];
                boardString += s + " | ";
            }
            boardString += "\n";
        }
        return boardString;
    }

}


