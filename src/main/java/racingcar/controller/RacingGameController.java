package racingcar.controller;

import java.util.List;
import racingcar.entity.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGameService racingGameService = new RacingGameService();

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        int rounds = inputView.inputRounds();

        List<Car> cars = racingGameService.createCars(carNames);
        racingGameService.startGame(cars, rounds);
    }
}
