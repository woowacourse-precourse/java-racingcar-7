package racingcar.validation;

import java.util.HashSet;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsValidator implements Validator<Cars>{
    private static final int MIN_CARS_AMOUNT = 2;

    @Override
    public void validate(Cars cars) {
        validateNameDuplication(cars);
        validateCarsSize(cars);
    }

    private void validateNameDuplication(Cars cars) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars.getCars()) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
            }
        }
    }

    private void validateCarsSize(Cars cars) {
        if (cars.getCars().size() < MIN_CARS_AMOUNT) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
    }
}
