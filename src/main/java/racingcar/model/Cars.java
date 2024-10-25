package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void registerCars(String carNamesInput) {
        for (String name : carNamesInput.split(",", -1)) {
            validateDuplication(name);
            cars.add(new Car(name));
        }
        validateCarsSize();
    }

    public void validateDuplication(String carName) {
        if (getCarNames().contains(carName)) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
        }
    }

    public void validateCarsSize() {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
    }

    private List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
