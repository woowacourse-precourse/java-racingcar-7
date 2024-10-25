package racingcar.car;

import static racingcar.global.constant.Config.MOVE_CONTROL_NUMBER;

import java.util.ArrayList;
import java.util.List;
import racingcar.number.generator.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(String name) {
        cars.add(new Car(name));
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> moveCar(car, numberGenerator.generateNumber()));
    }

    private void moveCar(Car car, int controlNumber) {
        if (controlNumber < MOVE_CONTROL_NUMBER) {
            return;
        }
    }

    public Car get(int index) {
        return cars.get(index);
    }
}
