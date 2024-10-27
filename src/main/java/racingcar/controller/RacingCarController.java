package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> carNames = InputView.getCarNames();
        int moveCount = InputView.getMoveCount();

        List<RacingCar> racingCars = racingCarService.generateRacingCarList(carNames);
        racingCarService.runCarRacing(racingCars, moveCount);

        List<RacingCar> winners = racingCarService.getWinnerRacingCars(racingCars);
        OutputView.printWinner(winners);
        Console.close();
    }
}
