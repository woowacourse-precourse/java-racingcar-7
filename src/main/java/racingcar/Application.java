package racingcar;

import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputPrinter printer = new OutputPrinter();
        InputHandler inputHandler = new InputHandler();

        printer.promptCarNames();
        String carNames = inputHandler.readInput();
        InputValidator carNamesValidator = new InputValidator(carNames);
        carNamesValidator.carNameValidator();

        printer.promptAttemptCount();
        String attemptCount = inputHandler.readInput();
        InputValidator attemptCountValidator = new InputValidator(attemptCount);
        attemptCountValidator.attemptCountValidator();

        LinkedHashMap<Car, Integer> cars = new InputParser(carNames).splitByComma();
        RaceController controller = new RaceController(cars, Long.parseLong(attemptCount));

        controller.start();
        printer.printWinner(controller.findWinner());
    }
}
