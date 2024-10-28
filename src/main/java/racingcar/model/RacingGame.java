package racingcar.model;

public class RacingGame {

    private RacingCars racingCars;
    private int tryNumber;

    public RacingGame(RacingCars racingCars, int tryNumber) {
        this.racingCars = racingCars;
        this.tryNumber = tryNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
