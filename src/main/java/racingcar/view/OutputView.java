package racingcar.view;

import racingcar.racing.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public static void printResult() {
        System.out.println("\n" + EXECUTION_RESULT_MESSAGE);
    }

    public static void printRaceStatus(List<Car> cars) {
        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            output.append(car.getStatus())
                    .append(System.lineSeparator());
        }
        System.out.println(output);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println(FINAL_WINNER_MESSAGE + winnerNames);
    }
}
