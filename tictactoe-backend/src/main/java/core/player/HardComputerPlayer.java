package core.player;

import core.board.Board;
import core.board.Piece;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

public class HardComputerPlayer extends MediumComputerPlayer {
    public HardComputerPlayer(final Piece piece, final Board board) {
        super(piece, board);
    }

    @Override
    public void makeMove() {
        if(tryToMove(getPiece())){
            return;
        }

        if(tryToMove(Piece.getOtherPiece(getPiece()))){
            return;
        }

        super.makeMove();

    }

    private boolean tryToMove(final Piece piece){
        int index = getMove(piece, getGameBoard().getDimensions());
        if (index != -1) {
            makeMove(index);
            return true;
        }
        return false;
    }

    private int getIndexOfLinearBlock(final Piece otherPiece, final int dimensions, final boolean isColumn) {
        final Map<Integer, Piece> pieces = new HashMap<>();
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (isColumn) {
                    pieces.put(i + dimensions * j, getGameBoard().getPieces()[i + dimensions * j]);
                } else {
                    pieces.put(j + i * dimensions, getGameBoard().getPieces()[j + i * dimensions]);
                }
            }
            if (hasToBlock(otherPiece, dimensions, pieces)) {
                return getIndexOfBlock(pieces);
            }
            pieces.clear();
        }
        return -1;
    }


    private int getIndexOfDiagonalBlock(final Piece otherPiece, final int dimensions, final boolean isLeft) {
        final Map<Integer, Piece> pieces = new HashMap<>();
        final int direction = isLeft ? 0 : 1;
        final int addend = isLeft ? 1 : -1;

        for (int i = direction; i < dimensions + direction; i++) {
            pieces.put((dimensions + addend) * i, getGameBoard().getPieces()[(dimensions + addend) * i]);
        }

        if (hasToBlock(otherPiece, dimensions, pieces)) {
            return getIndexOfBlock(pieces);
        }
        return -1;
    }


    private int getIndexOfBlock(final Map<Integer, Piece> pieces) {

        final Optional<Map.Entry<Integer, Piece>> indexOptional = pieces.entrySet().stream().filter(e -> e.getValue() == null).findFirst();
        return indexOptional.isPresent()
                ? indexOptional.get().getKey()
                : -1;
    }

    private boolean hasToBlock(final Piece otherPiece, final int dimensions, final Map<Integer, Piece> pieces) {
        return pieces.entrySet().stream().anyMatch(e -> e.getValue() == null)
                && pieces.entrySet().stream().filter(e -> e.getValue() == otherPiece).count() == dimensions - 1;
    }

    private int getMove(final Piece piece, final int dimensions) {
        final TreeSet<Integer> indexes = new TreeSet<>();
        indexes.add(getIndexOfLinearBlock(piece,dimensions, true));
        indexes.add(getIndexOfLinearBlock(piece, dimensions, false));
        indexes.add(getIndexOfDiagonalBlock(piece, dimensions, true));
        indexes.add(getIndexOfDiagonalBlock(piece, dimensions, false));
        return indexes.descendingSet().iterator().next();
    }


}
