package core.player;

import core.board.Board;
import core.board.Piece;

public class EasyComputerPlayer extends ComputerPlayer {
    public EasyComputerPlayer(final Piece piece, final Board board) {
        super(piece, board);
    }

    @Override
    public void makeMove() {
        int index = -1;
        final Piece[] board = getGameBoard().getPieces();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            makeMove(index);
        }
    }
}
