package racingcar.model.domain;

import racingcar.view.OutputView;

public interface Race {
    void runSingleRound();

    void runFullRace(OutputView outputView);
}
