package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Entity.Car;
import racingcar.service.RandomNumberGenerator;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberGenerator generator;
    private final List<List<Car>> history = new ArrayList<>();

    public RacingGame(List<Car> cars, RandomNumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
    }

    public void run(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            List<Car> roundResult = new ArrayList<>();
            for (Car car : cars) {
                if (generator.generate() >= 4) {
                    car.move();
                }
                roundResult.add(new Car(car));
            }
            history.add(roundResult);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<List<Car>> getHistory() {
        return history;
    }
}
