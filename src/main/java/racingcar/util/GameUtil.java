package racingcar.util;

import racingcar.domain.Car;
import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class GameUtil {

    public static List<String> prepareCarNames(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(",", -1));
        Validator.checkDuplicateNames(carNames);
        return carNames;
    }

    public static List<String> calculateWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
    }
}
