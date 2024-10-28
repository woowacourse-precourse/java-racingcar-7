package racingcar.util;

import racingcar.dto.RaceResult;
import java.util.List;
import java.util.stream.Collectors;

public class RaceProgressFormatter {

    private RaceProgressFormatter() {}

    public static List<String> toVisualProgress(RaceResult raceResult) {
        return raceResult.raceProgress().entrySet().stream()
                .map(entry -> entry.getKey() + " : " + "-".repeat(entry.getValue()))
                .collect(Collectors.toList());
    }
}
