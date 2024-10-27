package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.game.RacingCar;
import racingcar.exception.InvalidAttemptException;
import racingcar.model.game.attempt.Attempt;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Positions;
import racingcar.model.game.strategy.MovingStrategy;
import racingcar.support.repeater.StringRepeater;
import racingcar.support.splitter.Splitter;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Splitter splitter;
    private final MovingStrategy movingStrategy;
    private final StringRepeater stringRepeater;

    public RacingCarController(final InputView inputView, final OutputView outputView, final Splitter splitter,
                               final MovingStrategy movingStrategy,
                               final StringRepeater stringRepeater) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.splitter = splitter;
        this.movingStrategy = movingStrategy;
        this.stringRepeater = stringRepeater;
    }

    public void process() {
        String inputNames = readNames(outputView, inputView);
        Cars cars = initializeCars(splitter, inputNames, movingStrategy);
        Attempt attempt = readAttempt(outputView, inputView);

        RacingCar racingCar = new RacingCar(cars, attempt);
        showRacingResult(outputView, racingCar, stringRepeater);
        showWinners(racingCar);
    }

    private String readNames(OutputView outputView, InputView inputView) {
        outputView.showCommentForCarNames();
        return inputView.read();
    }

    private Cars initializeCars(final Splitter splitter, final String inputNames,
                                final MovingStrategy movingStrategy) {
        Cars cars = new Cars(new ArrayList<>());
        for (String name : splitter.splitFrom(inputNames)) {
            cars.add(new Car(name, movingStrategy));
        }
        return cars;
    }

    private Attempt readAttempt(OutputView outputView, InputView inputView) {
        outputView.showCommentForAttempt();
        String inputAttempt = inputView.read();
        validateInputAttempt(inputAttempt);
        return new Attempt(Long.parseLong(inputAttempt));
    }

    private void validateInputAttempt(final String inputAttempt) {
        if (inputAttempt == null || inputAttempt.isBlank()) {
            throw new InvalidAttemptException("시도 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private void showRacingResult(OutputView outputView, final RacingCar racingCar,
                                  final StringRepeater stringRepeater) {
        outputView.showCommentForResult();
        racingCar.start();
        Cars cars = racingCar.getCars();
        History history = racingCar.getHistory();
        for (Positions positions : history.values()) {
            outputView.showCarPosition(cars.names(), positions, stringRepeater);
        }
    }

    private void showWinners(final RacingCar racingCar) {
        String winners = racingCar.calculateWinners();
        outputView.showWinners(winners);
    }
}
