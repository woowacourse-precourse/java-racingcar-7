package racingcar.model;

import java.util.List;

public class Race {

    private Random random = new Random();

    public List<Car> play(List<Car> cars) {
        for (Car car : cars) {
            moveCarIfNeeded(car);
        }
        return cars;
    }

    private void moveCarIfNeeded(Car car) {
        int randomNumber = random.getRandomNumber();
        if (randomNumber >= 4) {
            car.move();
        }
    }
}
