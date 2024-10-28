package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarService racingCarService;
    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void startGame() {

        RacingCars racingCars = new RacingCars();
        RacingGame racingGame = readyRacingGame(racingCars);
        racingCarService.raceStart(racingGame);
    }

    private RacingGame readyRacingGame(RacingCars racingCars) {

        String inputCarNames = RacingCarView.inputCarNames();
        for (final String carName : inputCarNames.split(",")) {
            racingCars.add(new Car(carName));
        }

        int tryNum = Integer.parseInt(RacingCarView.inputTryNumber());

        return new RacingGame(racingCars, tryNum);
    }
}
