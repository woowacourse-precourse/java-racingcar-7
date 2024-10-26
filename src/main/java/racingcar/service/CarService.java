package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final List<Car> carList;

    public CarService() {
        this.carList = new ArrayList<>();
    }

    public void createCarList(String carNames) {
        List<String> carNameList = splitCarNames(carNames);

        for (String name : carNameList) {
            Car newCar = new Car(name.trim());
            if (isUniqueName(newCar)) {
                carList.add(newCar);
            }
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<String> splitCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("사용자 입력이 비어 있습니다.");
        }

        return List.of(carNames.split(","));
    }

    private boolean isUniqueName(Car newCar) {
        for (Car car : carList) {
            if (car.getName().equals(newCar.getName())) {
                return false;
            }
        }
        return true;
    }
}
