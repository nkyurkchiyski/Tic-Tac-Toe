package api.uiBeans;

public class MoveUiBean {
    private final String gameId;
    private final int index;

    public MoveUiBean(final String gameId, final int index) {
        this.gameId = gameId;
        this.index = index;
    }

    public String getGameId() {
        return gameId;
    }

    public int getIndex() {
        return index;
    }
}
