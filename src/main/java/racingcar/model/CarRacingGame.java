package racingcar.model;

import java.util.List;

public class CarRacingGame {

    private final Cars cars;
    private final Round round;

    public CarRacingGame(final Cars cars, final Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<CarInformation> playRound() {
        cars.runRace();
        nextRound();
        return cars.getAllCarsInformation();
    }

    public boolean canPlay() {
        return round.isOnGoing();
    }

    public List<CarInformation> getAllWinnersInformation() {
        return cars.calculateWinners();
    }

    private void nextRound() {
        round.advance();
    }
}