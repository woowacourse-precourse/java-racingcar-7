package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.exception.InvalidNameException;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void add(Car car) {
        validateDuplicateName(car);
        cars.add(car);
    }

    public List<Boolean> doMove() {
        return cars.stream()
                .map(Car::doesMove)
                .toList();
    }

    private void validateDuplicateNames(final List<Car> cars){
        long uniqueNameCount = cars.stream()
                .map(Car::name)
                .distinct()
                .count();

        if (uniqueNameCount != cars.size()) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private void validateDuplicateName(Car car) {
        if (isDuplicated(car.name())) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicated(Name name) {
        return cars.stream()
                .anyMatch(car -> car.name().equals(name));
    }

    public List<Name> names() {
        return cars.stream()
                .map(Car::name)
                .toList();
    }

    public int size() {
        return cars.size();
    }

    public Car at(final int index) {
        return cars.get(index);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars other = (Cars) o;
        return Objects.equals(cars, other.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
