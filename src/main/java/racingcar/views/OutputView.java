package racingcar.views;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_PER_ATTEMPTS_OUTPUT_MESSAGE = "실행 결과";
    private static final String RESULT_WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public static void printResultPerAttempts(final List<Car> cars) {
        System.out.println(RESULT_PER_ATTEMPTS_OUTPUT_MESSAGE);
        cars.forEach(car -> System.out.println(car.currentPositionFormat()));
        System.out.println();
    }

    public static void printWinner(final List<String> winnersName) {
        System.out.print(RESULT_WINNER_OUTPUT_MESSAGE);
        System.out.println(String.join(", ", winnersName));
    }
}
