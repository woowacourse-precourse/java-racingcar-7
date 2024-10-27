package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.Number;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Number number = new Number();
        Cars cars = new Cars();
        RacingCarGame racingCarGame = new RacingCarGame(inputView, outputView, number, cars);

        racingCarGame.initGame();
        racingCarGame.startRacingGame();
    }
}
