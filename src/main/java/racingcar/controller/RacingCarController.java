package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.view.RacingCarView;

public class RacingCarController {

    public void startGame() {

        RacingCars racingCars = new RacingCars();
        RacingGame racingGame = readyRacingGame(racingCars);
        racingGame.raceStart();
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
