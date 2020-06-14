package core.exception;

public class IllegalMoveException extends TicTacToeException{
    private static final String EXCEPTION = "This move is illegal. Try again.";

    public IllegalMoveException(){
        this(EXCEPTION);
    }

    public IllegalMoveException(final String message){
        super(message);
    }
}
