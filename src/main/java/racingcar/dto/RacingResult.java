package racingcar.dto;

import java.util.List;

public class RacingResult {

    private String result;
    private List<String> winnerNames;

    private RacingResult(String result, List<String> winnerNames) {
        this.result = result;
        this.winnerNames = winnerNames;
    }

    public static RacingResult of(String result, List<String> winnerNames) {
        return new RacingResult(result, winnerNames);
    }

    public String getResult() {
        return result;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
