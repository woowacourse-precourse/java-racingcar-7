package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars() {
    }

    public void add(Car car) {
        carList.add(car);
    }

    public List<Car> getWinners() {
        int maxPosition = carList.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow();

        return carList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    public void playRound() {
        carList.forEach(Car::playRound);
    }

    public List<Car> getCars() {
        return carList;
    }
}
