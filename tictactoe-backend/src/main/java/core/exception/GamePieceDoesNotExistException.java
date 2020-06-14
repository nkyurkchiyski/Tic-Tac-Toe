package core.exception;

public class GamePieceDoesNotExistException extends TicTacToeException {
    private static final String EXCEPTION = "The specified game piece does not exist. Select either O or X";

    public GamePieceDoesNotExistException(){
        super(EXCEPTION);
    }

}
