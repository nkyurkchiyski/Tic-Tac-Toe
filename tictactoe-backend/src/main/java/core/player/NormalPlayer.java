package core.player;

import core.board.Board;
import core.board.Piece;

public class NormalPlayer implements Player {
    private final Board board;

    private final Piece piece;

    public NormalPlayer(final Piece piece, final Board board) {
        this.piece = piece;
        this.board = board;
    }

    public void makeMove(final int index) {
        this.board.performSetPiece(this.piece, index);
    }

    public Board getGameBoard() {
        return board;
    }

    public Piece getPiece() {
        return piece;
    }
}
