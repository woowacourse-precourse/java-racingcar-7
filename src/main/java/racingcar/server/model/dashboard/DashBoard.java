package racingcar.server.model.dashboard;

import static java.util.Objects.requireNonNull;
import static racingcar.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.List;
import racingcar.server.model.car.Car;
import racingcar.server.model.car.Cars;

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
        String summary = String.join("\n", positions);
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
        return String.join(", ", winners);
    }
}
