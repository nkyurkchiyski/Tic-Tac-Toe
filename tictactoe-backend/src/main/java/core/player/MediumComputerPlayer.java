package core.player;

import core.board.Board;
import core.board.Piece;

public class MediumComputerPlayer extends ComputerPlayer {
    private final int[] preferredMoves = { 4, 0, 2, 6, 8, 1, 3, 5, 7 };
    public MediumComputerPlayer(final Piece piece, final Board board) {
        super(piece, board);
    }

    @Override
    public void makeMove() {
        int index = -1;
        final Piece[] board = getGameBoard().getPieces();
        for (int preferredMove : preferredMoves) {
            if (board[preferredMove] == null) {
                index = preferredMove;
                break;
            }
        }
        if (index != -1) {
            makeMove(index);
        }
    }
}
