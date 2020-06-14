package api;

import api.uiBeans.*;
import api.service.GameService;
import core.exception.TicTacToeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class TicTacToeApi {
    private final static String GENERAL_EXCEPTION_MESSAGE = "General Error have occurred. ";


    @Autowired
    private GameService gameService;

    @PostMapping("/game/new")
    public ResponseUiBean createGame(@RequestBody final NewGameUiBean newGameUiBean) {
        return createResponse(() -> gameService.createNewGame(newGameUiBean.getPiece(), newGameUiBean.getDifficulty()));
    }

    @PostMapping("/game")
    public ResponseUiBean makeMove(@RequestBody final MoveUiBean moveUiBean) {
        return createResponse(() -> gameService.performMove(moveUiBean.getGameId(), moveUiBean.getIndex()));
    }

    private ResponseUiBean createResponse(final Supplier<GameUiBean> supplier) {
        final ResponseUiBean response = new ResponseUiBean();
        try {
            response.setResponseObject(supplier.get());
            response.setCode(ResponseCode.OK.getCode());
        } catch (final TicTacToeException e) {
            response.setResponseObject(new ErrorUiBean(e.getClass(), e.getMessage()));
            response.setCode(ResponseCode.BAD_REQUEST.getCode());
        } catch (final Exception e) {
            response.setResponseObject(createGeneralError(e));
            response.setCode(ResponseCode.BAD_REQUEST.getCode());
        }

        return response;
    }

    private ErrorUiBean createGeneralError(final Exception e) {
        return new ErrorUiBean(e.getClass(), GENERAL_EXCEPTION_MESSAGE + e.getMessage());
    }
}
