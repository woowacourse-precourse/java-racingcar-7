package racingcar;

import java.util.List;
import racingcar.car.Cars;

public class Game {

    private static final String START_MESSAGE = "\n실행 결과";

    public static void run() {
        try {
            String input = InputManager.readUserInput();
            List<String> names = NameExtractor.getNames(input);

            Cars cars = new Cars(names);

            int tryCount = InputManager.readTryCount();
            race(cars, tryCount);

            List<String> winnerNames = cars.getWinnerNames();
            OutputManager.printWinner(winnerNames);
        } finally {
            InputManager.close();
        }
    }

    private static void race(Cars cars, int tryCount) {

        printStartMessage();

        for(int i = 0; i< tryCount; i++) {
            cars.attemptMoveAllCars();
            printNewLine();
        }
    }

    private static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
