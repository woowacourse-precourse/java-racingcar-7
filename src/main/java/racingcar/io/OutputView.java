package racingcar.io;

import static racingcar.global.constant.Message.MOVEMENT_RESULT_MESSAGE;
import static racingcar.global.constant.Message.READ_CAR_NAME_MESSAGE;
import static racingcar.global.constant.Message.READ_MOVEMENT_NUMBER_MESSAGE;
import static racingcar.global.constant.Message.WINNER_MESSAGE;

import java.util.List;
import racingcar.car.Cars;

public class OutputView {
    public void printCarNameMessage() {
        println(READ_CAR_NAME_MESSAGE);
    }

    public void printMovementNumberMessage() {
        println(READ_MOVEMENT_NUMBER_MESSAGE);
    }

    public void printCarStatement(Cars cars) {
        println(getCarState(cars));
        print("\n");
    }

    private String getCarState(Cars cars) {
        return cars.toString();
    }

    public void printMovementResultMessage() {
        println(MOVEMENT_RESULT_MESSAGE);
    }

    public void printWinner(List<String> winners) {
        String winner = String.join(", ", winners);
        println(WINNER_MESSAGE + winner);
    }

    private void println(String string) {
        System.out.println(string);
    }

    private void print(String string) {
        System.out.print(string);
    }
}
