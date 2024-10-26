package racingcar.model.dashboard;

import static java.util.Objects.requireNonNull;
import static racingcar.common.constant.SystemConstant.NEW_LINE;
import static racingcar.common.constant.SystemConstant.WINNER_DELIMITER;
import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class DashBoard {

    private final Cars cars;
    private final LapCharts lapCharts;

    // Constructor
    private DashBoard(final Cars cars) {
        this.cars = cars;
        lapCharts = LapCharts.initiate();
    }

    public static DashBoard from(final Cars cars) {
        requireNonNull(cars, SHOULD_NOT_BE_NULL);
        return new DashBoard(cars);
    }

    // Method
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
}
