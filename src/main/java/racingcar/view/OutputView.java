package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private final Cars cars;
    private final String PROGRESS_FORMAT = "%s : %s";
    private final String RESULT_FORMAT = "최종 우승자 : %s";

    public OutputView(Cars cars) {
        this.cars = cars;
    }

    public void printProgress() {
        cars.getCars().stream()
                .map(car -> String.format(PROGRESS_FORMAT, car.getName(), makeDashLine(car.getPosition())))
                .forEach(System.out::println);
    }

    public void printResult() {
        List<Car> winners = cars.findWinners();
        String formattedString = String.join(", ", winners.stream().map(Car::getName).toList());

        System.out.printf((RESULT_FORMAT) + "%n", formattedString);
    }

    private String makeDashLine(int position) {
        return "-".repeat(position);
    }
}
