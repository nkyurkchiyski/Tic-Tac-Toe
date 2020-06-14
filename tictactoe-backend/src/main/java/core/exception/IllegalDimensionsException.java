package core.exception;

public class IllegalDimensionsException extends TicTacToeException {
    private static final String EXCEPTION = "The specified dimensions are not permitted. The dimensions have to be an integer bigger than 0";

    public IllegalDimensionsException(){
        super(EXCEPTION);
    }
}
