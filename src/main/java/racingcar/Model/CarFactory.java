package racingcar.Model;

import racingcar.Utils.ApplicationConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .peek(CarFactory::validateCarName) // 여기서 유효성 검사
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > ApplicationConstants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ApplicationConstants.CAR_NAME_VALIDATION_MESSAGE);
        }
    }
}