package racingcar.model;

public class RaceRound {
    private final int rounds;
    private Cars thisRoundCars;

    public RaceRound(int roundInput, Cars thisRoundCars) {
        this.thisRoundCars = thisRoundCars;
        this.rounds = roundInput;
    }

    public int getRounds() {
        return this.rounds;
    }

    public Cars getThisRoundCars() {
        return thisRoundCars;
    }

    public void roundStart(Cars cars) {
        for (Car car : cars.getCarList()) {
            car.moveIfTrue(car.getRandomValue());
        }
    }

    public void saveRoundResult(Cars cars) {
        this.thisRoundCars = cars;
    }
}
