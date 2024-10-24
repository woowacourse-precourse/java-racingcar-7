package model;

import java.util.List;

public class RacingGame {
    private long round;
    private List<RacingCar> cars;

    public RacingGame(List<RacingCar> cars, long round) {
        this.cars = cars;
        this.round = round;
    }
}
