package racingcar.ui;

import racingcar.domain.car.Car;

import java.util.List;

public interface UserOutput {

    void printRaceStatus(List<Car> cars);

    void printWinners(List<String> winners);
}
