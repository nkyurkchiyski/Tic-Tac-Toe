package core.board;

import core.util.GameUtils;
import core.exception.IllegalDimensionsException;
import core.exception.MoveOutOfBoundsException;
import core.exception.PlaceAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class GameBoard implements Board {

    private final static int DIM = 3;

    private final Piece[] board;

    private int dimensions;

    public GameBoard(final int dimensions) {
        GameUtils.checkArgument(dimensions > 0, IllegalDimensionsException::new);
        this.dimensions = dimensions;
        this.board = new Piece[this.dimensions * this.dimensions];
    }

    public GameBoard() {
        this(DIM);
    }

    public GameBoard(final Board board){
        //copy constructor
        this.dimensions = board.getDimensions();
        this.board = board.getPieces();
    }

    public boolean hasWinner() {
        return isWinner(Piece.O) || isWinner(Piece.X);
    }

    private boolean isWinner(final Piece piece) {
        return checkColumns(piece) || checkDiagonals(piece) || checkRows(piece);
    }

    public boolean isFinished() {
        return hasWinner() || isFull();
    }

    private boolean isFull() {
        return Arrays.stream(this.board).noneMatch(Objects::isNull);
    }

    public Piece getWinner() {
        Piece winner = null;
        if (isWinner(Piece.O)) {
            winner = Piece.O;
        } else if (isWinner(Piece.X)) {
            winner = Piece.X;
        }
        return winner;
    }

    public Piece[] getPieces() {
        return this.board;
    }

    @Override
    public Integer[] getAvailablePositions() {
        final Collection<Integer> availablePositions = new ArrayList<>();
        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i] == null){
                availablePositions.add(i);
            }
        }
        return availablePositions.toArray(Integer[]::new);
    }


    public void performSetPiece(final Piece piece, final int index) {
        GameUtils.checkNotNull(piece);
        GameUtils.checkArgument(index < DIM * DIM, MoveOutOfBoundsException::new);
        GameUtils.checkArgument(this.board[index] == null, PlaceAlreadyOccupiedException::new);
        setPiece(piece, index);
    }

    public void setPiece(final Piece piece, final int index){
        this.board[index] = piece;
    }

    private boolean checkRows(final Piece piece) {
        final ArrayList<Piece> pieces = new ArrayList<>(dimensions);
        for (int i = 0; i < dimensions; i++) {
            int curr = i * dimensions;
            pieces.addAll(Arrays.asList(this.board).subList(curr, curr + dimensions));
            if (pieces.stream().allMatch(x -> x == piece)){
                return true;
            }
            pieces.clear();
        }
        return false;
    }

    private boolean checkColumns(final Piece piece) {
        final ArrayList<Piece> pieces = new ArrayList<>(dimensions);
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                pieces.add(this.board[i + dimensions * j]);
            }
            if (pieces.stream().allMatch(x -> x == piece)){
                return true;
            }
            pieces.clear();
        }
        return false;
    }

    private boolean checkDiagonals(final Piece piece) {
        return checkLeftDiagonal(piece) || checkRightDiagonal(piece);
    }

    private boolean checkLeftDiagonal(final Piece piece) {
        final ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            pieces.add(this.board[(dimensions + 1) * i]);
        }
        return pieces.stream().allMatch(x -> x == piece);
    }

    private boolean checkRightDiagonal(final Piece piece) {
        final ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 1; i <= dimensions; i++) {
            pieces.add(this.board[(dimensions - 1) * i]);
        }
        return pieces.stream().allMatch(x -> x == piece);
    }

    public int getDimensions() {
        return this.dimensions;
    }

}
