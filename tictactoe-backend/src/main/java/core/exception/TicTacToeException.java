package core.exception;

public class TicTacToeException extends RuntimeException
{
    public TicTacToeException()
    {
        super("An in-game error occurred.");
    }

    public TicTacToeException(final String message)
    {
        super(message);
    }


    public TicTacToeException(final Throwable cause)
    {
        super(cause);
    }


    public TicTacToeException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
