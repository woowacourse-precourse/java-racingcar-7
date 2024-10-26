package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void registerAll(List<String> names) {
        validateNamesSize(names);

        names.forEach(name -> {
            Car car = Car.from(name);
            validate(car);
            cars.add(car);
        });
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        Integer winnerPosition = cars.stream().map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream().filter(car -> car.getPosition() == winnerPosition).toList();
    }

    private void validate(Car car) {
        validateCarsSize();
        validateDuplicate(car);
    }

    private void validateNamesSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최소 2개입니다.");
        }
    }

    private void validateDuplicate(Car carForRegistration) {
        boolean isDuplicate = cars.stream().anyMatch(carForRegistration::equals);
        if (isDuplicate) {
            throw new IllegalArgumentException("게임 내 중복된 이름이 존재합니다.");
        }
    }

    private void validateCarsSize() {
        if (cars.size() >= 10) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최대 10개입니다.");
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
