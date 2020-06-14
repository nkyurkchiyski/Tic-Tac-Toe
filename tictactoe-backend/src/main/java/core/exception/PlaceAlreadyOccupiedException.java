package core.exception;

public class PlaceAlreadyOccupiedException extends IllegalMoveException{
    private static final String EXCEPTION = "The place is already occupied. Try again.";

    public PlaceAlreadyOccupiedException(){
        super(EXCEPTION);
    }
}
