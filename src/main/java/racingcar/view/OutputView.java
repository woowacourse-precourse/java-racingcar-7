package racingcar.view;

import java.util.List;
import racingcar.message.SystemMessage;
import racingcar.model.Car;

public class OutputView {

    public static void printSetCarNameMessage() {
        System.out.println(SystemMessage.INPUT_CAR_NAME_MESSAGE.getMessage());
    }

    public static void printSetTryNumberMessage() {
        System.out.println(SystemMessage.INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }

    public static void printRacingResultMessage() {
        System.out.println(SystemMessage.OUTPUT_RACING_RESULT_MESSAGE.getMessage());
    }

    public static void printRacingResult(List<Car> carList) {
        carList.forEach(Car -> System.out.println(Car.getName() + " : " + "-".repeat(Car.getPosition())));
        System.out.println();
    }

    public static void printResultWinner(String winner) {
        System.out.println(SystemMessage.OUTPUT_WINNER_MESSAGE.getMessage() + winner);
    }
}
