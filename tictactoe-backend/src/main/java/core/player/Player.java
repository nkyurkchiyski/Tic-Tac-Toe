package core.player;

import core.board.Board;
import core.board.Piece;

public interface Player {
    void makeMove(final int index);

    Board getGameBoard();

    Piece getPiece();
}
