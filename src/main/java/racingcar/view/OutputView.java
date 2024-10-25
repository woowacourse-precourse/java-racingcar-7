package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DETAIL = " : ";
    private static final String DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자" + DETAIL;
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printResult(final Cars cars) {
        cars.getCars().stream()
                .map(car -> getCarName(car) + DETAIL + getMovingDistance(car))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(final List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(DELIMITER, winners));
    }

    public static void printErrorMessage(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    private static String getCarName(final Car car) {
        return car.getName().getCarName();
    }

    private static String getMovingDistance(final Car car) {
        return car.getPosition().getDistance();
    }
}
