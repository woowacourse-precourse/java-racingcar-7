package racingcar.domain;

import java.util.List;

public class RacingResult {
    private final List<String> roundResults;

    public RacingResult(List<String> roundResults) {
        this.roundResults = roundResults;
    }

    public List<String> getRoundResults() {
        return roundResults;
    }
}
