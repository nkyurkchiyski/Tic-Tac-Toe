package core.game;

import core.board.Board;
import core.board.GameBoard;
import core.board.Piece;
import core.player.ComputerPlayer;
import core.player.NormalPlayer;
import core.player.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Game {
    private String gameId = UUID.randomUUID().toString();

    private Piece winner = null;

    private boolean isFinished = false;

    private static final int PLAYER_COUNT = 2;

    private final Player[] players = new Player[PLAYER_COUNT];

    private final Board gameBoard;

    public Game(final Piece piece, final GameDifficulty gameDifficulty) {
        final Piece otherPiece = Piece.getOtherPiece(piece);
        this.gameBoard = new GameBoard();
        this.players[0] = new NormalPlayer(piece, gameBoard);

        try {
            this.players[1] = invokeComputerPlayer(gameDifficulty.getComputerPlayerClass(), otherPiece, gameBoard);
        } catch (final NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        if (piece == Piece.X) {
            ((ComputerPlayer) this.players[1]).makeMove();
        }
    }

    public void performTurn(final int index) {
        if (!isFinished) {
            for (int i = 0; i < PLAYER_COUNT; i++) {
                if (players[i] instanceof ComputerPlayer) {
                    final ComputerPlayer bot = (ComputerPlayer) players[i];
                    bot.makeMove();
                } else {
                    players[i].makeMove(index);
                }
            }

            if (this.gameBoard.isFinished()) {
                winner = this.gameBoard.getWinner();
                isFinished = true;
            }
        }
    }

    public Piece getWinner() {
        return winner;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public String getId() {
        return gameId;
    }

    private ComputerPlayer invokeComputerPlayer(final Class clazz,
                                                final Piece piece,
                                                final Board board)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Constructor cons = clazz.getConstructor(Piece.class, Board.class);
        return (ComputerPlayer)cons.newInstance(piece, board);
    }
}
