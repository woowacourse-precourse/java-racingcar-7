package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String nameInput) {
        for (String name : nameInput.split(",")) {
            validateDuplicatedName(name);
            this.cars.add(new Car(name));
        }
    }

    private void validateDuplicatedName(String name) {
        for (Car car : this.cars) {
            if (car.getName().equals(name)) {
                throw new IllegalArgumentException("중복되는 이름은 사용할 수 없습니다.");
            }
        }
    }

    public void race(IntegerGenerator generator) {
        for (Car car : this.cars) {
            car.moveForward(generator.generate());
            car.printState();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
