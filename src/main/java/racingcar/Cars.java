package racingcar;

import java.util.ArrayList;
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

    private void validate(Car car) {
        validateCarsSize();
        validateDuplicate(car);
    }

    private void validateNamesSize(List<String> names) {
        if(names.size() < 2) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최소 2개입니다.");
        }
    }

    private void validateDuplicate(Car carForRegistration) {
        boolean isDuplicate = cars.stream().anyMatch(carForRegistration::equals);
        if(isDuplicate) {
            throw new IllegalArgumentException("게임 내 중복된 이름이 존재합니다.");
        }
    }

    private void validateCarsSize() {
        if(cars.size() >= 10) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최대 10개입니다.");
        }
    }
}
