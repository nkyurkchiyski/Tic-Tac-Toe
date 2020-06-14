package core.player;

import core.board.Board;
import core.board.Piece;

public abstract class ComputerPlayer extends NormalPlayer {
    public ComputerPlayer(final Piece piece, final Board board) {
        super(piece, board);
    }

    public abstract void makeMove();

}
