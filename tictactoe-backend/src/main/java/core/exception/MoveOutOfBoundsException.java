package core.exception;

public class MoveOutOfBoundsException extends IllegalMoveException {
    private static final String EXCEPTION = "Your move is out of bounds. Try again.";

    public MoveOutOfBoundsException(){
        super(EXCEPTION);
    }
}
