package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
