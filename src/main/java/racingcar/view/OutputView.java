package racingcar.view;

import racingcar.dto.RacingRoundResult;
import racingcar.model.RacingCars;

import java.util.List;

public interface OutputView {

    void printInputCarNames();

    void printInputTryCount();

    void printRacingRoundResults(List<RacingRoundResult> racingRoundResults);

    void printWinners(RacingCars racingCars);
}
