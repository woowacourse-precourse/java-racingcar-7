package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(String carNames) {
        this.cars = getCars(carNames);
        validateSize();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> {
            car.moveFront(RandomNumberGenerator.generate());
        });
    }

    private List<Car> getCars(String carNames) {
        return Arrays.stream(carNames.split(",")).toList()
                .stream().map(Car::new).toList();
    }

    private void validateSize() {
        if (this.cars.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 적어도 두 개 입력해야 합니다.");
        }
    }
}
