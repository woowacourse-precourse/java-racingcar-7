package racingcar.controller;

import static racingcar.factory.CarFactory.createCars;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingService = new RacingService();
    }

    public void run() {
        ArrayList<String> carNames = inputView.inputCarName();
        int gameCount = Integer.parseInt(inputView.inPutGameCount());

        List<Car> cars = createCars(carNames);

        for (int i = 0; i < gameCount; i++) {
            racingService.race(cars);
        }

        List<Car> winners = racingService.findWinners(cars);
        outputView.printResult(winners);

    }

}
