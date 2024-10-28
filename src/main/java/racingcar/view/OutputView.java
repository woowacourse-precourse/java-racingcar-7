package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String EXECUTION_RESULTS = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void executionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULTS);
    }

    public static void RoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void finalWinner(List<Car> winners) {
        var winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(FINAL_WINNER + winnerNames);
    }
}
