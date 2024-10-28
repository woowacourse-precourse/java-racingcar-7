package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s%n";

    public void displayCurrentPositions(List<Car> cars) {
        System.out.println(RESULT_HEADER);
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void displayWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.printf(WINNER_MESSAGE, winnerNames);
    }
}