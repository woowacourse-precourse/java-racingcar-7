package racingcar.controller;

import java.util.List;
import racingcar.model.CarRacing;
import racingcar.model.RacingCar;
import racingcar.view.CarRacingView;

public class CarRacingController {

    public CarRacingController() {
    }

    public void race(final List<String> names, final int moveForwardTryCount) {
        List<RacingCar> racingCars = names.stream()
                .map(RacingCar::new)
                .toList();

        CarRacing carRacing = new CarRacing(racingCars, moveForwardTryCount);

        while (carRacing.getMoveForwardTryCount() >= 1) {
            carRacing.tryMoveForward();
            CarRacingView.displayCurrentStatus(racingCars);
        }
        CarRacingView.displayRaceResult(carRacing.getRaceWinners());
    }
}
