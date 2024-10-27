package racingcar.app.server.model.dashboard;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.List;
import racingcar.app.server.model.car.Car;
import racingcar.app.server.model.car.Cars;

public class DashBoard {

    private final Cars cars;
    private final LapCharts lapCharts;

    private DashBoard(final Cars cars) {
        this.cars = cars;
        lapCharts = LapCharts.initiate();
    }

    public static DashBoard from(final Cars cars) {
        requireNonNull(cars, SHOULD_NOT_BE_NULL);
        return new DashBoard(cars);
    }

    public void offerLapChart() {
        List<String> positions = cars.currentPositions();
        String summary = String.join("\n", positions);
        lapCharts.offer(summary);
    }

    public List<String> offerAllLapCharts() {
        return lapCharts.offerLapCharts();
    }

    public List<String> offerLWinners() {
        return cars.filterCompletedAllLap()
                .stream()
                .map(Car::toString)
                .toList();
    }
}
