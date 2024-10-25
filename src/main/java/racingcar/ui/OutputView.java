package racingcar.ui;

import racingcar.domain.car.Cars;

import java.util.List;

public interface OutputView {

    void printRaceStatus(Cars cars);

    void printWinners(List<String> winners);
}
