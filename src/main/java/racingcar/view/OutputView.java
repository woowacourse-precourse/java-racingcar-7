package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULT = "\n실행 결과";
    private static final String COLON = " : ";
    private static final String LINE = "-";
    private static final String DELIMITER = ", ";

    public static void printRacingResultMessage() {
        System.out.println(RESULT);
    }

    public static void printRacingCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + COLON + LINE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printRaceWinners(Winners winners) {
        String winnerNames = String.join(DELIMITER, winners.getWinnerNames());
        System.out.println(WINNER_MESSAGE + winnerNames);
    }
}
