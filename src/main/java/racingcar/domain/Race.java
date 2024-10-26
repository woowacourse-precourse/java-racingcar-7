package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumber;
import racingcar.util.Validator;

public class Race {

    private final List<Car> cars;
    private final int tryCount;

    public Race(List<Car> Cars, int tryCount) {
        this.cars = new ArrayList<>();
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomNumber.generateRandomNumber();
            if (Validator.isMoreFour(randomNumber)) {
                car.move();
            }
        }
    }

    public void playRace() {
        for (int i = 0; i < tryCount; i++) {
            playOneRound(cars);
        }
    }

}
