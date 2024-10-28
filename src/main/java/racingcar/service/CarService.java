package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.utils.ErrorMessage;
import racingcar.utils.Util;

public class CarService {
    public List<Car> createCars(String carsName) {
        List<String> carNames = Util.splitByComma(carsName);
        validateCarNames(carNames);
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

    }

    private void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }
    }
}
