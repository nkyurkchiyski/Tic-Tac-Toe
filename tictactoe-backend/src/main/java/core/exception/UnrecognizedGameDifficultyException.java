package core.exception;

public class UnrecognizedGameDifficultyException extends TicTacToeException {
    private static final String EXCEPTION = "The specified game difficulty does not exist. Select 'easy', 'medium' or 'hard'";

    public UnrecognizedGameDifficultyException(){
        super(EXCEPTION);
    }
}
