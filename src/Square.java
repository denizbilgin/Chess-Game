public class Square {
    private int column;
    private int row;
    private Piece piece;

    public Square(int row, int column) {
        this.column = column;
        this.row = row;
        this.piece = null;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isAtLastRow(int color) {
        if ((color == ChessBoard.WHITE && this.row == 0) || (color == ChessBoard.BLACK && this.row == 7)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (this.piece == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtSameDiagonal(Square s) {
        return Math.abs(s.row - this.row) == Math.abs(s.column - this.column);
    }

    public boolean isAtSameColumn(Square s) {
        if (this.column == s.column) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtSameRow(Square s) {
        if (this.row == s.row) {
            return true;
        } else {
            return false;
        }
    }

    public ChessBoard getBoard() {
        return Main.board;
    }

    public boolean isNeighborColumn(Square targetLocation) {
        if (this.column + 1 == targetLocation.column || this.column - 1 == targetLocation.column) {
            return true;
        } else {
            return false;
        }
    }

    public int getRowDistance(Square s) {
        return s.row - this.row;
    }

    public int getColumnDistance(Square s) {
        return s.column - this.column;
    }

    public void putNewQueen(int color) {
        if (color == ChessBoard.WHITE) {
            this.piece = new Queen(ChessBoard.WHITE, this.piece.location);
        } else {
            this.piece = new Queen(ChessBoard.BLACK, this.piece.location);
        }
    }

    public void clear() {
        this.piece = null;
    }
}
