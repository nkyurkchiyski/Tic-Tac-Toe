package core.game;

import core.exception.UnrecognizedGameDifficultyException;
import core.player.ComputerPlayer;
import core.player.EasyComputerPlayer;
import core.player.HardComputerPlayer;
import core.player.MediumComputerPlayer;

import java.util.Arrays;

public enum GameDifficulty {
    EASY("easy", EasyComputerPlayer.class),
    MEDIUM("medium", MediumComputerPlayer.class),
    HARD("hard", HardComputerPlayer.class);

    private final String difficulty;
    private final Class<ComputerPlayer> clazz;

    GameDifficulty(final String difficulty, final Class<? extends ComputerPlayer> computerPlayerClass) {
        this.difficulty = difficulty;
        this.clazz = (Class<ComputerPlayer>) computerPlayerClass;
    }

    public Class<ComputerPlayer> getComputerPlayerClass() {
        return clazz;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public static GameDifficulty getByDifficulty(final String difficultyString) {
        return Arrays.stream(values())
                .filter(x -> x.getDifficulty().equals(difficultyString.toLowerCase()))
                .findFirst()
                .orElseThrow(UnrecognizedGameDifficultyException::new);
    }
}
