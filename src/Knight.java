public class Knight extends Piece{
    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = Math.abs(targetLocation.getRowDistance(location));
        int columnDistance = Math.abs(targetLocation.getColumnDistance(location));

        if (rowDistance * columnDistance == 2) {
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
        return color == ChessBoard.WHITE ? "N" : "n";
    }
}
