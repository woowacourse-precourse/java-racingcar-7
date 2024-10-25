package racingcar.model.dashboard;

import static racingcar.common.constant.SystemConstant.NEW_LINE;
import static racingcar.common.constant.SystemConstant.WINNER_DELIMITER;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class DashBoard {
    private final Cars cars;
    private final LapCharts lapCharts;

    private DashBoard(final Cars cars) {
        this.cars = cars;
        lapCharts = LapCharts.initiate();
    }

    public static DashBoard from(Cars cars) {
        return new DashBoard(cars);
    }

    public void offerLapChart() {
        List<String> positions = cars.currentPositions();
        String summary = String.join(NEW_LINE, positions);
        lapCharts.offer(summary);
    }

    public String lapCharts() {
        return lapCharts.toString();
    }

    public String rankWinners() {
        List<String> winners = cars.filterCompletedAllLap()
                .stream()
                .map(Car::toString)
                .toList();
        return String.join(WINNER_DELIMITER, winners);
    }
}
