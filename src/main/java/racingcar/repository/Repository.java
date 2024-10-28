package racingcar.repository;

import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingRecording;
import racingcar.model.dto.RacingWinners;

/** 자동차 경주 결과를 저장하는 저장소 */
public interface Repository {

    void saveStartMessage();

    void saveProgress(RacingProgress progress);

    void saveBreakingLine();

    void saveResult(RacingWinners racingWinners);

    RacingRecording getRecord();

}
