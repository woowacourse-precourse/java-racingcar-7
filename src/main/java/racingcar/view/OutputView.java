package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.util.Constants.*;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GAME_START.getMessage());
    }

    public void printRoundMessage() {
        System.out.println(GAME_COUNT.getMessage());
    }

    public void printResultMessage() {
        System.out.println(GAME_RESULT.getMessage());
    }

    public void printRaceMessage(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }

        System.out.println();
    }

    public void printWinnerMessage(List<String> winners) {
        System.out.println(GAME_END.getMessage() + String.join(", ", winners));
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
