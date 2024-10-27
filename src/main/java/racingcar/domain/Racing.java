package racingcar.domain;

import java.util.List;
import static racingcar.util.RandomNumber.getRandomNumber;

public class Racing {
    public void startRace(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            int distance = generateRandomDistance();
            car.move(distance);
        }
    }
    private int generateRandomDistance() {
        return getRandomNumber();
    }
}