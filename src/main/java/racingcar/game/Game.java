package racingcar.game;

import java.util.List;
import racingcar.car.Cars;
import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.utils.NameExtractor;

public class Game {

    private static final String START_MESSAGE = "\n실행 결과";

    public static void run() {
        try {
            String input = InputManager.readUserInput();
            List<String> names = NameExtractor.getNames(input);

            Cars cars = new Cars(names);

            int attemptCount = InputManager.readAttemptCount();
            race(cars, attemptCount);

            cars.showWinner();
        } finally {
            InputManager.close();
        }
    }

    private static void race(Cars cars, int attemptCount) {

        printStartMessage();

        for (int i = 0; i < attemptCount; i++) {
            cars.attemptMovingAllCars();
            cars.showAllCarsStatus();
            printNewLine();
        }
    }

    private static void printStartMessage() {
        OutputManager.printMessage(START_MESSAGE);
    }

    private static void printNewLine() {
        OutputManager.printMessage();
    }
}
