package racingcar.domain;

import java.util.List;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void printCarPositions() {
        for (Car car : cars) {
            System.out.println(car.getName() + "의 위치: " + car.getPosition());
        }
    }
}
