package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RaceGame;

public class RaceController {

    private final RaceGame raceGame;

    public RaceController(List<Car> raceCars) {
        this.raceGame = new RaceGame(raceCars);
    }

    public void start(int count){
        for (int i = 0; i < count; i++) {
            raceGame.start();
        }
    }
}
