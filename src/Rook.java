public class Rook extends Piece{
    public Rook(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);

        for (int i=0; i<between.length; i++) {
            if (between[i].getPiece() != null && between[i].getPiece() != location.getPiece() && between[i].getPiece() != targetLocation.getPiece())
            {
                return validMove;
            }
        }

        // kalenin sadece dikey-yatay gidebileceğini kontrol etmek
        if (this.location.isAtSameRow(targetLocation) || this.location.isAtSameColumn(targetLocation)) {
            if (targetLocation.isEmpty()) {
                validMove = true;
            } else {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() != color;
            }
        }
        return validMove;
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "R" : "r";
    }
}
