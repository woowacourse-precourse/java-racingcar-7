package racingcar.dto;

import racingcar.domain.Cars;
import racingcar.domain.RacingGames;

public class ResultDTO {
    private String gameResult;
    private String finalWinner;

    public ResultDTO(String gameResult, String finalWinner) {
        this.gameResult = gameResult;
        this.finalWinner = finalWinner;
    }

    public String getGameResult() {
        return gameResult;
    }

    public String getFinalWinner() {
        return finalWinner;
    }
}
