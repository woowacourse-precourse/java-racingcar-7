package racingcar.repository;

import racingcar.model.dto.CarRacingProgress;
import racingcar.model.dto.RacingResult;
import racingcar.model.dto.RacingWinners;

public interface Repository {

    void saveProgress(CarRacingProgress progress);

    void saveBreakingLine();

    void saveResult(RacingWinners racingWinners);

    void saveStartMessage();

    RacingResult getResult();
}
