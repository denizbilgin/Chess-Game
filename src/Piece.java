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

    public void setColor(int color) {
        this.color = color;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }



    public void move(String destination)
    {
        return;
    }

    public boolean canMove(String destination)
    {
        return true;
    }
}
