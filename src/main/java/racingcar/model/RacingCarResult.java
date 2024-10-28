package racingcar.model;

import java.util.List;

public record RacingCarResult(
    List<RacingTrialLog> racingTrialLogs,
    List<String> winners
) {
    public static RacingCarResult map(
        List<RacingTrialLog> racingTrialLogs,
        List<String> winners
    ) {
        return new RacingCarResult(
            racingTrialLogs,
            winners
        );
    }
}
