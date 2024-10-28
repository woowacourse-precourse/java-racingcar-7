package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.RacingGameCount;
import racingcar.view.input.GameInputView;
import racingcar.view.input.RacingGameInputConsole;
import racingcar.view.output.OutputView;
import racingcar.view.output.RacingGameOutPutView;

public class RacingGameController implements GameInputView {
    private final RacingGameInputConsole inputView;

    public RacingGameController() {
        this.inputView = new RacingGameInputConsole();
    }

    @Override
    public void start() {
        Game game = createGame();
        game.play();
    }

    private Game createGame() {
        String carNames = inputView.readCarsInput();
        Cars cars = Cars.createCarsFrom(carNames);

        String tryCountInput = inputView.readTryCountInput();
        RacingGameCount count = new RacingGameCount(tryCountInput);

        OutputView resultView = new RacingGameOutPutView();
        return new RacingGame(cars, count, resultView);
    }
}
