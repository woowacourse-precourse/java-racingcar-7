package racingcar.model.dashboard;

import static java.util.Objects.isNull;
import static racingcar.common.constant.SystemConstant.NEW_LINE;
import static racingcar.common.constant.SystemConstant.WINNER_DELIMITER;

import java.util.List;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class DashBoard {
    private final Cars cars;
    private final LapCharts lapCharts;

    private DashBoard(final Cars cars) {
        this.cars = cars;
        lapCharts = LapCharts.initiate();
    }

    public static DashBoard from(final Cars cars) {
        validateIsNull(cars);
        return new DashBoard(cars);
    }

    public void offerLapChart() {
        List<String> positions = cars.currentPositions();
        String summary = String.join(NEW_LINE, positions);
        lapCharts.offer(summary);
    }

    public String offerLapCharts() {
        return lapCharts.toString();
    }

    public String offerLWinners() {
        List<String> winners = cars.filterCompletedAllLap()
                .stream()
                .map(Car::toString)
                .toList();
        return String.join(WINNER_DELIMITER, winners);
    }

    private static void validateIsNull(Cars cars) {
        if (isNull(cars)) {
            throw new ShouldNotBeNullException();
        }
    }
}
