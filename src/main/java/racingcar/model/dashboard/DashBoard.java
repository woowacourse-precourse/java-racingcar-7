package racingcar.model.dashboard;

import static racingcar.common.constant.SystemConstant.NEW_LINE;
import static racingcar.common.constant.SystemConstant.WINNER_DELIMITER;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class DashBoard {
    private final Cars cars;

    private DashBoard(final Cars cars) {
        this.cars = cars;
    }

    public static DashBoard of(Cars cars) {
        return new DashBoard(cars);
    }

    public String offerLapChart() {
        List<String> positions = cars.currentPositions();
        return String.join(NEW_LINE, positions);
    }

    public String offerWinners() {
        List<String> winners = cars.filterCompletedAllLap()
                .stream()
                .map(Car::toString)
                .toList();
        return String.join(WINNER_DELIMITER, winners);
    }
}
