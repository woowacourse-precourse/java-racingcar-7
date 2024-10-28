package racingcar.raceInterface;

import racingcar.model.Cars;

public interface Observer {
    void displayOneTrial();

    void displayWinner();

    void updateGoTrial(Cars goTrialResult);

    void updateWinner(Cars winnerResult);
}
