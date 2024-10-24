package racingcar.domain;

import java.util.List;

import static racingcar.utils.RandomNumberGenerator.generateRandomNumber;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAll() {
        carList.forEach(car -> car.move(generateRandomNumber()));
    }
}
