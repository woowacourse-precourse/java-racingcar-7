package racingcar.controller;

import racingcar.model.cars.Cars;
import racingcar.model.racerounds.RaceRounds;

public class RaceController {

    public void race(Cars cars, RaceRounds rounds) {
        boolean moved = cars.moveForward();
        if (moved == false) {
            race(cars, rounds);
        }
        rounds.moveNextRound();
    }
}
