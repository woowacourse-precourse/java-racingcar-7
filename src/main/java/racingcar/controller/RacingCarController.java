package racingcar.controller;

import java.util.ArrayList;
import racingcar.RacingCar;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;
import racingcar.model.attempt.Attempt;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.position.History;
import racingcar.model.position.Positions;
import racingcar.strategy.MovingStrategy;
import racingcar.util.splitter.Splitter;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class RacingCarController {

    private static final String COMMA = ",";

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Splitter splitter;
    private final MovingStrategy movingStrategy;

    public RacingCarController(final InputHandler inputHandler, final OutputHandler outputHandler,
                               final Splitter splitter,
                               final MovingStrategy movingStrategy) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.splitter = splitter;
        this.movingStrategy = movingStrategy;
    }

    public void process() {
        String inputNames = readNames(outputHandler, inputHandler);
        Cars cars = initializeCars(splitter, inputNames, movingStrategy);
        Attempt attempt = readAttempt(outputHandler, inputHandler);

        RacingCar racingCar = new RacingCar(cars, attempt);
        showRacingResult(outputHandler, racingCar);
        showWinners(racingCar);
    }

    private String readNames(OutputHandler outputHandler, InputHandler inputHandler) {
        outputHandler.showCommentForCarNames();
        String inputNames = inputHandler.read();
        validateInputNames(inputNames);
        return inputNames;
    }

    private void validateInputNames(final String value) {
        if (value.endsWith(COMMA)) {
            throw new InvalidNameException("이름은 비어있을 수 없습니다.");
        }
    }

    private Cars initializeCars(final Splitter splitter, final String inputNames,
                                final MovingStrategy movingStrategy) {
        Cars cars = new Cars(new ArrayList<>());
        for (String name : splitter.splitFrom(inputNames, COMMA)) {
            cars.add(new Car(name, movingStrategy));
        }
        return cars;
    }

    private Attempt readAttempt(OutputHandler outputHandler, InputHandler inputHandler) {
        outputHandler.showCommentForAttempt();
        String inputAttempt = inputHandler.read();
        validateInputAttempt(inputAttempt);
        return new Attempt(Long.parseLong(inputAttempt));
    }

    private void validateInputAttempt(final String inputAttempt) {
        if (inputAttempt == null || inputAttempt.isBlank()) {
            throw new InvalidAttemptException("시도 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private void showRacingResult(OutputHandler outputHandler, final RacingCar racingCar) {
        outputHandler.showCommentForResult();
        racingCar.start();
        Cars cars = racingCar.getCars();
        History history = racingCar.getHistory();
        for (Positions positions : history.values()) {
            outputHandler.showCarPosition(cars.names(), positions.getValues());
        }
    }

    private void showWinners(final RacingCar racingCar) {
        String winners = racingCar.calculateWinners();
        outputHandler.showWinners(winners);
    }
}
