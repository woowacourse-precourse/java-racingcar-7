package racingcar;

import static racingcar.view.inputCar;
import static racingcar.view.inputCount;
import static racingcar.view.printWinner;
import static racingcar.controller.gameProgress;

public class Application {

    public static void main(String[] args) {
        inputCar();
        inputCount();
        gameProgress();
        printWinner();
    }
}
