package racingcar.model.domain;

import racingcar.view.OutputView;

import java.util.List;

public interface Race {
    void runSingleRound();

    void runFullRace(OutputView outputView);
}
