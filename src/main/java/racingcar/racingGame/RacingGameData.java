package racingcar.racingGame;

import racingcar.car.Car;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RacingGameData {

    private final List<Car> cars = new ArrayList<>();
    private BigInteger attempts;

    public RacingGameData() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public BigInteger getAttempts() {
        return attempts;
    }

    public void initialize(List<String> carNames, BigInteger attempts) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.attempts = attempts;
    }
}
