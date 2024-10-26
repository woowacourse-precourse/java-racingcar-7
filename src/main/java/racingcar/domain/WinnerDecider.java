package racingcar.domain;

import racingcar.dto.RaceResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerDecider {

    public List<String> determineWinners(RaceResult raceResult) {
        Map<String, Integer> raceProgress = raceResult.raceProgress();

        int maxProgress = raceProgress.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return raceProgress.entrySet().stream()
                .filter(entry -> entry.getValue() == maxProgress)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
