package racingcar.view;

import racingcar.domain.CarDomains;

public interface OutputView {
    String displayCarNameRequest();

    String displayRoundRequest();

    String displayRoundResultString();

    String displayEachRoundStatus(CarDomains cars);

    String displayCarRaceWinner(CarDomains winners);
}
