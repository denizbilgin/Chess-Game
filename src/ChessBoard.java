public class ChessBoard {
    private Square[][] board;
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    private boolean whitePlaying;

    // Constructor
    public ChessBoard() {
        board = new Square[8][8];
        initialize();
        whitePlaying = true;
    }

    public void initialize() {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j);
            }
        }
        board[0][0].setPiece(new Rook(1,board[0][0]));
        board[0][1].setPiece(new Knight(1,board[0][1]));
        board[0][2].setPiece(new Bishop(1,board[0][2]));
        board[0][3].setPiece(new Queen(1,board[0][3]));
        board[0][4].setPiece(new King(1,board[0][4]));
        board[0][5].setPiece(new Bishop(1,board[0][5]));
        board[0][6].setPiece(new Knight(1,board[0][6]));
        board[0][7].setPiece(new Rook(1,board[0][7]));

        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(new Pawn(1,board[1][j]));
            board[6][j].setPiece(new Pawn(0,board[6][j]));
        }

        board[7][0].setPiece(new Rook(0,board[7][0]));
        board[7][1].setPiece(new Knight(0,board[7][1]));
        board[7][2].setPiece(new Bishop(0,board[7][2]));
        board[7][3].setPiece(new Queen(0,board[7][3]));
        board[7][4].setPiece(new King(0,board[7][4]));
        board[7][5].setPiece(new Bishop(0,board[7][5]));
        board[7][6].setPiece(new Knight(0,board[7][6]));
        board[7][7].setPiece(new Rook(0,board[7][7]));
    }

    public boolean isGameEnded() {
        int amountOfBlackPieces = 0;
        int amountOfWhitePieces = 0;

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (this.board[i][j].getPiece() == null) {
                    continue;
                }

                if (this.board[i][j].getPiece().color == ChessBoard.WHITE) {
                    amountOfWhitePieces++;
                } else if (this.board[i][j].getPiece().color == ChessBoard.BLACK) {
                    amountOfBlackPieces++;
                }
            }
        }

        if (amountOfBlackPieces == 0 || amountOfWhitePieces == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Square getSquareAt(String to) {
        int column = this.charToInt(to.charAt(0));
        int row = 8-Character.getNumericValue(to.charAt(1));
        return board[row][column];
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation) {
        if (location.isAtSameColumn(targetLocation)) {
            int numberOfSquaresBetween = targetLocation.getRow() - location.getRow();
            if (numberOfSquaresBetween < 0) {
                numberOfSquaresBetween *= -1;
            }

            Square[] tempArr = new Square[numberOfSquaresBetween];
            int counter = location.getRow() > targetLocation.getRow() ? targetLocation.getRow() : location.getRow();
            for (int i=0; i<numberOfSquaresBetween; i++) {
                if (location.getPiece().color == ChessBoard.BLACK) {
                    tempArr[i] = this.board[counter + 1][location.getColumn()];
                } else {
                    tempArr[i] = this.board[counter][location.getColumn()];
                }
                counter++;
            }
            return tempArr;

        } else if (location.getRow() == targetLocation.getRow()) {
            int numberOfSquaresBetween = targetLocation.getColumn() - location.getColumn();
            numberOfSquaresBetween = numberOfSquaresBetween < 0 ? numberOfSquaresBetween * (-1) : numberOfSquaresBetween;

            Square[] tempArr = new Square[numberOfSquaresBetween];
            int counter = location.getColumn() > targetLocation.getColumn() ? targetLocation.getColumn() : location.getColumn();
            for (int i=0; i<numberOfSquaresBetween; i++) {
                tempArr[i] = board[location.getRow()][counter];
                counter++;
            }
            return tempArr;

        } else if (location.isAtSameDiagonal(targetLocation)) {
            int rowDistance = Math.abs(location.getRowDistance(targetLocation));
            //int columnDistance = Math.abs(location.getColumnDistance(targetLocation));
            int numberOfSquaresBetween = rowDistance - 1;

            Square[] tempArr = new Square[numberOfSquaresBetween];

            int rowDirection = targetLocation.getRow() > location.getRow() ? 1 : -1;
            int columnDirection = targetLocation.getColumn() > location.getColumn() ? 1 : -1;

            int currentRow = location.getRow() + rowDirection;
            int currentColumn = location.getColumn() + columnDirection;

            for (int i=0; i<numberOfSquaresBetween; i++) {
                tempArr[i] = board[currentRow][currentColumn];
                currentRow += rowDirection;
                currentColumn += columnDirection;
            }
            return tempArr;
        }
        return null;
    }

    public void nextPlayer() {
        this.whitePlaying = !this.whitePlaying;
    }

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public Piece getPieceAt(String to) {
        int column = this.charToInt(to.charAt(0));
        int row = 8-Character.getNumericValue(to.charAt(1));
        return board[row][column].getPiece();
    }

    private int charToInt(char c) {
        switch (c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                // if user enter like 'z'
                return 9;
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += "    A   B   C   D   E   F   G   H\n";
        s += "------------------------------------\n";
        for (int i=0; i<8; i++)
        {
            s += (8-i) + " | ";
            for (int j=0; j<8; j++)
            {
                if (this.board[i][j].getPiece() == null)
                {
                    s += "  | ";
                }
                else
                {
                    s += this.board[i][j].getPiece().toString() + " | ";
                }
            }
            s += "  " + (8-i) + "\n";
            s += "------------------------------------\n";
        }
        s += "    A   B   C   D   E   F   G   H\n";
        return s;
    }
}
