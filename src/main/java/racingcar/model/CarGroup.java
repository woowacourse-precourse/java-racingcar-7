package racingcar.model;

import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<String> carNames) {
        this.cars = carNames.stream().map(Car::new).toList();
        validateSize();
    }

    private void validateSize() {
        if (this.cars.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 적어도 두 개 입력해야 합니다.");
        }
    }

    public void move() {
        cars.forEach(car -> {
            car.moveFront(RandomNumberGenerator.generate());
        });
    }
}
