package racingcar.dto;

import java.util.Map;
import racingcar.domain.CarPosition;

public class GameResultDto {
    Map<String, CarPosition> gameData;

    public GameResultDto(Map<String, CarPosition> gameData) {
        this.gameData = gameData;
    }

    public Map<String, CarPosition> getGameData() {
        return gameData;
    }

    public void setGameData(Map<String, CarPosition> gameData) {
        this.gameData = gameData;
    }
}
