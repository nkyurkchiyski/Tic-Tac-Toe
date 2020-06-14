package api.service;

import api.uiBeans.GameUiBean;
import api.uiBeans.converter.GameUiBeanConverter;
import core.game.Game;
import core.game.GameDifficulty;
import core.board.Piece;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, Game> currentGames = new HashMap<>();

    @Override
    public GameUiBean createNewGame(final String piece, final String difficulty) {
        final Piece gamePiece = Piece.getByGamePiece(piece);
        final GameDifficulty gameDifficulty = GameDifficulty.getByDifficulty(difficulty);
        return createNewGame(gamePiece, gameDifficulty);
    }

    @Override
    public GameUiBean createNewGame(final Piece piece, final GameDifficulty gameDifficulty) {
        final Game game = new Game(piece, gameDifficulty);
        this.currentGames.put(game.getId(), game);
        return GameUiBeanConverter.convertToGameUiBean(game);
    }

    @Override
    public GameUiBean performMove(final String gameId, final int index) {
        final Game game = this.currentGames.get(gameId);
        game.performTurn(index);
        return GameUiBeanConverter.convertToGameUiBean(game);
    }

    @Override
    public GameUiBean getGame(final String gameId) {
        return GameUiBeanConverter.convertToGameUiBean(this.currentGames.get(gameId));
    }
}
