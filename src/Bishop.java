public class Bishop extends Piece{
    public Bishop(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);

        Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
        for (int i=0; i<between.length; i++) {
            if (between[i].getPiece() != null) {
                return validMove;
            }
        }

        // filin sadece çapraz gidebileceğini kontrol etmek
        if (this.location.isAtSameDiagonal(targetLocation)) {
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
        return color == ChessBoard.WHITE ? "B" : "b";
    }
}
