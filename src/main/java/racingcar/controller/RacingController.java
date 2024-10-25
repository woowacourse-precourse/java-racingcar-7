package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.Racing;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Racing racing;
    private CarManager carManager;
    private OutputView outputView;
    private RacingService racingService;

    public RacingController(Racing racing, CarManager carManager, RacingService racingService,
            OutputView outputView) {
        this.racing = racing;
        this.carManager = carManager;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void start() {
        racingService.setupCarsFromUserInput(InputView.getInputCarString());
        executeRaceRounds();
        announceWinner();
    }

    private void executeRaceRounds() {
        int cnt = Integer.parseInt(InputView.getInputRepeatCount());
        outputView.printGameResultMessage();
        for (int i = 0; i < cnt; i++) {
            runSingleRound();
            outputView.printEmptyLine();
        }
    }

    private void announceWinner() {
        String winner = racing.findWinner(carManager.getCars());
        outputView.printWinner(winner);
    }

    private void runSingleRound() {
        List<Car> cars = racing.startRacing();
        for (Car car : cars) {
            outputView.printGameResult(car.getName(), car.getMovedDistance());
        }
    }

}
