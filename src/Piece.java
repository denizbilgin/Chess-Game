public class Piece {

    int color;
    protected Square location;

    public int getColor() {
        return color;
    }

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }


    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
    }

    public boolean canMove(String to) {
        return true;
    }
}
