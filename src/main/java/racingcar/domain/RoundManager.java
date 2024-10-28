package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundManager {
    private final List<RacingResult> racingResults;

    public RoundManager() {
        this.racingResults = new ArrayList<>();
    }

    public void recordRoundResult(List<String> currentRoundResults) {
        if (!currentRoundResults.isEmpty()) {
            racingResults.add(new RacingResult(currentRoundResults));
        }
    }

    public List<List<String>> getAllRoundResults() {
        return racingResults.stream()
                .map(RacingResult::getRoundResults)
                .collect(Collectors.toList());
    }

    public List<String> getLatestRoundResults() {
        if (racingResults.isEmpty()) {
            return new ArrayList<>();
        }
        return racingResults.get(racingResults.size() - 1).getRoundResults();
    }
}
