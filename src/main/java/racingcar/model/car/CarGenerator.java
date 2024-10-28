package racingcar.model.car;

import static racingcar.constant.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGenerator {

    public List<String> extractCarNames(String carInput) {
        List<String> splitResult = List.of(carInput.split(","));
        validateCarInput(splitResult);

        return splitResult;
    }

    public Cars generateCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }

        return cars;
    }

    private void validateCarInput(List<String> splitResult) {
        if (splitResult.size() < 2) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT.getValue());
        }

        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : splitResult) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getValue());
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException(INVALID_CAR_DUPLICATE.getValue());
            }
        }
    }
}
