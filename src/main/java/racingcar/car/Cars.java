package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.InvalidNameException;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void add(Car car) {
        validate(car);
        cars.add(car);
    }

    public List<Boolean> doMove() {
        return cars.stream()
                .map(Car::doesMove)
                .toList();
    }

    private void validate(Car car) {
        if (isDuplicateName(car.name())) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicateName(String name) {
        return cars.stream()
                .anyMatch(car -> car.name().equals(name));
    }

    public int size() {
        return cars.size();
    }

    public List<String> names() {
        return cars.stream()
                .map(Car::name)
                .toList();
    }

    public String name(final Integer index) {
        return cars.get(index).name();
    }
}
