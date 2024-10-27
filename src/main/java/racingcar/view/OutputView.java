package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private final static String NEW_LINE = "\n";
    private final static String COLON = " : ";
    private final static String HYPHEN = "-";
    private final static String COMMA_SPACE = ", ";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private final static String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public static void executionResultMessage() {
        System.out.print(NEW_LINE);
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void currentStatusMessage(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + COLON + HYPHEN.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void finalWinnerMessage(List<Car> winners) {
        List<String> carNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        String message = FINAL_WINNER_MESSAGE + String.join(COMMA_SPACE, carNames);
        System.out.println(message);
    }


}
