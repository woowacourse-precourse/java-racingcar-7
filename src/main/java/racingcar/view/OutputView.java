package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final Cars cars;
    private final String PROGRESS_FORMAT = "%s : %s";
    private final String RESULT_FORMAT = "최종 우승자 : %s";

    public OutputView(Cars cars) {
        this.cars = cars;
    }

    public String generateProgress() {
        return cars.getCars().stream()
                .map(car -> String.format(PROGRESS_FORMAT, car.getName(), makeDashLine(car.getPosition())))
                .collect(Collectors.joining("\n"));
    }

    public void printProgress() {
        System.out.println(generateProgress() + "\n");
    }

    public String generateWinners() {
        List<Car> winners = cars.findWinners();
        String formattedString = String.join(", ", winners.stream().map(Car::getName).toList());

        return String.format(RESULT_FORMAT, formattedString);
    }

    public void printWinners() {
        System.out.println(generateWinners());
    }

    private String makeDashLine(int position) {
        return "-".repeat(position);
    }
}
