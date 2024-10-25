package racingcar.view.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class ConsoleOutputView implements OutPutView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    @Override
    public void printMessage() {
        System.out.println(System.lineSeparator() + EXECUTION_RESULT_MESSAGE);
    }

    @Override
    public void printResult(final List<Car> cars) {
        final StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append(System.lineSeparator());
        }
        System.out.println(result);
    }

    @Override
    public void printWinners(final List<Car> winners) {
        final String winnerNames = WINNERS_MESSAGE + winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }
}
