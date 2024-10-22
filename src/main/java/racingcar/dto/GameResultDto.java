package racingcar.dto;

import java.util.Map;

public class GameResultDto {
    Map<String, Integer> gameData;

    public GameResultDto(Map<String, Integer> gameData) {
        this.gameData = gameData;
    }

    public Map<String, Integer> getGameData() {
        return gameData;
    }

    public void setGameData(Map<String, Integer> gameData) {
        this.gameData = gameData;
    }
}
