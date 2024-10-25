package racingcar.model.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.ErrorMessage;
import racingcar.model.parser.CarsParser;

public class Cars {
    private final List<Car> cars;

    public Cars(final String carNames) {
        final List<Car> cars = createCarList(carNames);
        validateCars(cars);
        this.cars = cars;
    }

    private List<Car> createCarList(final String carNames) {
        return CarsParser.parse(carNames);
    }

    private void validateCars(final List<Car> cars) {
        validateEmptyInput(cars);
        validateDuplicatedName(cars);
    }

    private void validateEmptyInput(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST.getMessage());
        }
    }

    private void validateDuplicatedName(final List<Car> cars) {
        Set<Car> expectedCarsList = new HashSet<>(cars);
        if (expectedCarsList.size() != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.CONFLICT_ERROR.getMessage());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
