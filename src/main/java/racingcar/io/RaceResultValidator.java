package racingcar.io;

import java.util.List;
import racingcar.constants.ExceptionMessages;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.dto.RaceResult;

public class RaceResultValidator {

    public void validateRaceResult(RaceResult raceResult) {
        if (raceResult == null) {
            throw new IllegalArgumentException(ExceptionMessages.RACE_RESULT_NOT_EXIST);
        }
        validateLapResults(raceResult.getLapResults());
        validateWinners(raceResult.getWinners());
    }

    private void validateLapResults(List<LapResult> lapResults) {
        if (lapResults == null || lapResults.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.LAP_RESULT_NOT_EXIST);
        }
    }

    private void validateWinners(List<CarStatus> winners) {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.WINNER_NOT_EXIST);
        }
    }
}