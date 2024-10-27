package racingcar.controller;

import racingcar.model.CarGame;
import racingcar.model.Cars;
import racingcar.model.GameResults;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    private RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static RacingCarController of(InputView inputView, OutputView outputView) {
        return new RacingCarController(inputView, outputView);
    }

    public void control() {
        Cars cars = inputView.getCarNamesFromUser();
        int tryNumber = inputView.getTryNumberFromUser();

        CarGame carGame = CarGame.of(cars, tryNumber);
        GameResults gameResults = carGame.play();
        outputView.showGameResults(gameResults);
    }

}
