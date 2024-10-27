package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.InputService;
import racingcar.service.RacingGameService;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    public final RacingGameService racingGameService;
    public final InputService inputService;

    public RacingGameController(RacingGameService racingGameService, InputService inputService) {
        this.racingGameService = racingGameService;
        this.inputService = inputService;
    }

    public void run() {
        List<String> carNames = inputService.getRacingCarNamesFromUser();
        int trial = inputService.getTrialCountFromUser();

        List<Car> racingCars = racingGameService.createCarsWithUniqueName(carNames);

        OutputView.printResultHeader();
        List<Car> finishedCars = racingGameService.runRounds(trial, racingCars);

        List<String> winnerNames = racingGameService.selectWinners(finishedCars);
        OutputView.printWinners(winnerNames);
    }
}
