package core.board;

public interface Board {

    void performSetPiece(final Piece piece, final int index);

    void setPiece(final Piece piece, final int index);

    boolean hasWinner();

    boolean isFinished();

    Piece getWinner();

    Piece[] getPieces();

    Integer[] getAvailablePositions();

    int getDimensions();
}
