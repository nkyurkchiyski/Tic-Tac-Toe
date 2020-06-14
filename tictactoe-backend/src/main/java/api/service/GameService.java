package api.service;

import api.uiBeans.GameUiBean;
import core.game.GameDifficulty;
import core.board.Piece;

public interface GameService {

    GameUiBean createNewGame(final String piece, final String difficulty);

    GameUiBean createNewGame(final Piece piece, final GameDifficulty gameDifficulty);

    GameUiBean performMove(final String gameId, final int index);

    GameUiBean getGame(final String gameId);
}
