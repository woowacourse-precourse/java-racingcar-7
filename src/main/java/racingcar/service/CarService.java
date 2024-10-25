package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarService {

    private static final int FORWARD_CONDITION = 4;
    private final NumberGenerator numberGenerator;

    public CarService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(String::trim).peek(name -> {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
        }).map(Car::new).toList();
    }

    private boolean canMove() {
        if (numberGenerator.generate() >= FORWARD_CONDITION) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void moveCars(List<Car> cars) {
        cars.stream().filter(car -> canMove()).forEach(Car::goForward);
    }

}
