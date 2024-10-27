package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_HEADER = "실행 결과";

    private String formatCarResult(Car car) {
        return car.getName() + " : " +
                "-".repeat(car.getDistance()) +
                NEW_LINE;
    }

    private String formatWinners(List<String> winner) {
        return WINNER_MESSAGE + String.join(", ", winner);
    }

    public void printResult(Cars cars) {
        System.out.println(RESULT_HEADER);
        String result = cars.getCars().stream()
                .map(this::formatCarResult)
                .collect(Collectors.joining());
        System.out.print(result);
    }

    public void printWinner(List<String> winner) {
        System.out.print(formatWinners(winner));
    }
}
