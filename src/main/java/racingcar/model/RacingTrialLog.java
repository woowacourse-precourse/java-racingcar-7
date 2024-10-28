package racingcar.model;

import java.util.List;

public record RacingTrialLog(
    List<String> carNames,
    List<Integer> progresses
) {
    public static RacingTrialLog map(
        List<String> carNames,
        List<Integer> progresses
    ) {
        return new RacingTrialLog(
            carNames,
            progresses
        );
    }
}
