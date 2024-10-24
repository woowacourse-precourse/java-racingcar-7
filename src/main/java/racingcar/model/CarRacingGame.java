package racingcar.model;

import java.util.List;

public class CarRacingGame {

    private final CarRacingGameConfig gameConfig;

    private Cars cars;
    private Round round;

    public CarRacingGame(final CarRacingGameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void initialize(final List<String> names, final int round) {
        initializeCars(names);
        initializeRound(round);
    }

    public List<CarInformation> playRound() {
        cars.runRace();
        return cars.getAllCarInformation();
    }

    public boolean canPlay() {
        return round.isOnGoing();
    }

    public void nextRound() {
        round.advance();
    }

    private void initializeCars(final List<String> names) {
        CarCreator carFactory = gameConfig.carFactory();
        CarMovementPolicy movementPolicy = gameConfig.carMovementPolicy();
        cars = carFactory.createCars(names, movementPolicy);
    }

    private void initializeRound(final int round) {
        this.round = new Round(round);
    }
}