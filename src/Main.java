import java.util.Scanner;

public class Main {
    public static ChessBoard board;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        board = new ChessBoard();
        System.out.println(board);

        while (!board.isGameEnded()){
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece = null;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                piece = board.getPieceAt(from);
            }while(piece == null || piece.getColor()!=(board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK));
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            }while(!piece.canMove(to));
            piece.move(to);
            System.out.println(board);
        }
        reader.close();
        System.out.println("Good Game!");
        String winnerMessage = board.isWhitePlaying() ? "Black" : "White";
        winnerMessage += " player wins!";
        System.out.println(winnerMessage);
    }

    // şah çekmek, arayüz, her promote, piyon 1 gitmek, oynana hamleleri tutan array, king gibi classlardaki if(targetLocation.isEmpty()) kısmını basitleştir (rook gibi)
    // parantezleri checkle
}
