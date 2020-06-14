package api.uiBeans.converter;

import api.uiBeans.GameUiBean;
import core.game.Game;

public class GameUiBeanConverter {
    public static GameUiBean convertToGameUiBean(final Game game){
        final GameUiBean bean = new GameUiBean();
        bean.setId(game.getId());
        bean.setFinished(game.getGameBoard().isFinished());
        bean.setWinner(game.getGameBoard().getWinner());
        bean.setPieces(game.getGameBoard().getPieces());
        return bean;
    }
}
