package racingcar.domain;

public class RacingCarGameResult {
    private String gameResult;
    private String gameWinnerNames;

    public RacingCarGameResult(String gameResult, String gameWinnerNames) {
        this.gameResult = gameResult;
        this.gameWinnerNames = gameWinnerNames;
    }

    public String getGameResult() {
        return gameResult;
    }

    public String getGameWinnerNames() {
        return gameWinnerNames;
    }
}
