package model;

import java.util.List;

public class RacingGame {
    private int round;
    private List<RacingCar> cars;
    private RacingGameService racingGameService;

    public RacingGame(List<RacingCar> cars, int round, RacingGameService racingGameService) {
        this.cars = cars;
        this.round = round;
        this.racingGameService = racingGameService;
    }

    public void startRace() {
        racingGameService.progress(cars, round);
    }
}
