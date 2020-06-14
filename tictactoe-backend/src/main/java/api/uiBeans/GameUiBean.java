package api.uiBeans;

import core.board.Piece;

public class GameUiBean {
    private String id;
    private Piece winner;
    private Piece[] pieces;
    private boolean isFinished;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Piece getWinner() {
        return winner;
    }

    public void setWinner(final Piece winner) {
        this.winner = winner;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(final Piece[] pieces) {
        this.pieces = pieces;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(final boolean finished) {
        isFinished = finished;
    }
}
