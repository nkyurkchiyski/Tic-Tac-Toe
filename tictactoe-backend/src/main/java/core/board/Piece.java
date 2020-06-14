package core.board;

import core.exception.GamePieceDoesNotExistException;

import java.util.Arrays;

public enum Piece {
    O('O', 0),
    X('X', 1);

    private final char gamePiece;
    private final int turn;

    Piece(char gamePiece, int turn) {
        this.gamePiece = gamePiece;
        this.turn = turn;
    }

    public char getGamePiece() {
        return gamePiece;
    }

    public int getTurn() {
        return turn;
    }

    public static Piece getOtherPiece(final Piece piece) {
        return Arrays.stream(Piece.values()).filter(x -> x != piece).findAny().orElse(null);
    }

    public static Piece getByGamePiece(final String gamePiece) {
        return Arrays.stream(Piece.values()).filter(x -> Character.toString(x.getGamePiece()).toLowerCase().equals(gamePiece.toLowerCase()))
                .findFirst()
                .orElseThrow(GamePieceDoesNotExistException::new);
    }
}
