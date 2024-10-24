package racingcar.repository;

import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingResult;
import racingcar.model.dto.RacingWinners;

public interface Repository {

    void saveProgress(RacingProgress progress);

    void saveBreakingLine();

    void saveResult(RacingWinners racingWinners);

    void saveStartMessage();

    RacingResult getResult();
}
