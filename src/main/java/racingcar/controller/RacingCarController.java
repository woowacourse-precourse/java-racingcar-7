package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.view.RacingCarView;

public class RacingCarController {

    public void startGame() {
        RacingCars racingCars = new RacingCars();
        RacingGame racingGame = readyRacingGame(racingCars);
        racingGame.raceStart();
        racingGame.raceFinish();
    }

    private RacingGame readyRacingGame(RacingCars racingCars) {
        String inputCarNames = RacingCarView.inputCarNames();
        InputValidator.checkCarNameEmpty(inputCarNames);

        for (final String inputCarName : inputCarNames.split(",")) {
            String carName = inputCarName.trim();
            InputValidator.checkCarNameLength(carName);
            racingCars.add(new Car(carName));
        }

        int tryNum;
        try {
            tryNum = Integer.parseInt(RacingCarView.inputTryNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        InputValidator.checkTryNumNegative(tryNum);

        return new RacingGame(racingCars, tryNum);
    }
}
