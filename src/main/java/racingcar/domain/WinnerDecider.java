package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

import racingcar.dto.RaceResult;
import racingcar.exception.RacingCarException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerDecider {

    public List<String> determineWinners(RaceResult raceResult) {
        Map<String, Integer> raceProgress = raceResult.raceProgress();
        validateRaceProgressNotEmpty(raceProgress);

        int maxProgress = findMaxProgress(raceProgress);
        return findWinnersWithMaxProgress(raceProgress, maxProgress);
    }

    private void validateRaceProgressNotEmpty(Map<String, Integer> raceProgress) {
        if (raceProgress.isEmpty()) {
            throw RacingCarException.from(RACE_RESULT_EMPTY);
        }
    }

    private int findMaxProgress(Map<String, Integer> raceProgress) {
        return raceProgress.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> findWinnersWithMaxProgress(Map<String, Integer> raceProgress, int maxProgress) {
        return raceProgress.entrySet().stream()
                .filter(entry -> entry.getValue() == maxProgress)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
