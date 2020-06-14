package api.uiBeans;

public class NewGameUiBean {
    private final String piece;
    private final String difficulty;

    public NewGameUiBean(final String piece, final String difficulty) {
        this.piece = piece;
        this.difficulty = difficulty;
    }

    public String getPiece() {
        return piece;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
