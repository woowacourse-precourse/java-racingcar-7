package racingcar.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final String CAR_DELIMITER = ",";

    public List<Car> createCar(String raceCar) {
        return Arrays.stream(raceCar.split(CAR_DELIMITER))
                .map(carName -> {
                    validateName(carName);
                    return new Car(carName);
                })
                .collect(Collectors.toList());
    }

    public void validateName(String carName) {
        if (!isUsableName(carName)) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
        }
    }

    public boolean isUsableName(String carName) {
        return carName.length() <= 5;
    }
}
