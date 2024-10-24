package racingcar.ui;

import racingcar.domain.car.Cars;

import java.util.List;

public interface UserOutput {

    void printRaceStatus(Cars cars);

    void printWinners(List<String> winners);
}
