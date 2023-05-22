
public class King extends Piece{
    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int columnDistance = targetLocation.getColumnDistance(location);

        if (rowDistance < 2 && columnDistance < 2) {
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
        return color == ChessBoard.WHITE ? "K" : "k";
    }
}
