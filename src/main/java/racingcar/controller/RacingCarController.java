package racingcar.controller;

import java.util.ArrayList;
import racingcar.exception.InvalidRoundException;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.RacingCar;
import racingcar.model.game.round.Round;
import racingcar.model.game.position.History;
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
        Round round = readRound(outputView, inputView);

        RacingCar racingCar = new RacingCar(cars, round);
        showRacingResult(outputView, round, racingCar, stringRepeater);
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

    private Round readRound(OutputView outputView, InputView inputView) {
        outputView.showCommentForRound();
        String inputRound = inputView.read();
        validateInputRound(inputRound);
        return new Round(Long.parseLong(inputRound));
    }

    private void validateInputRound(final String inputRound) {
        if (inputRound == null || inputRound.isBlank()) {
            throw new InvalidRoundException("라운드 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private void showRacingResult(OutputView outputView, final Round round, final RacingCar racingCar,
                                  final StringRepeater stringRepeater) {
        outputView.showCommentForResult();
        racingCar.start();
        Cars cars = racingCar.cars();
        History history = racingCar.history();
        for (int index = 0; index < round.round(); index++) {
            outputView.showCarPosition(cars.names(), history.at(index), stringRepeater);
        }
    }

    private void showWinners(final RacingCar racingCar) {
        String winners = racingCar.calculateWinners();
        outputView.showWinners(winners);
    }
}
