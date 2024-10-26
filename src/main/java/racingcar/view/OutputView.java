package racingcar.view;

import racingcar.domain.CarDomains;

public interface OutputView {
    void displayRoundResultString();

    void displayEachRoundStatus(CarDomains cars);

    void displayCarRaceWinner(CarDomains winners);
}
