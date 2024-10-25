package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingController {

    private final RacingCarView racingCarView;

    public RacingController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void run() {
        List<String> racingCarNames = racingCarView.getRacingCarNames();
        RacingCars racingCars = RacingCars.of(racingCarNames);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2));

        int totalLaps = 2;
        for (int i = 0; i < totalLaps; i++) {
            racingCars.race();
        }

        List<RacingCar> winners = racingCars.getWinners();
    }

}
