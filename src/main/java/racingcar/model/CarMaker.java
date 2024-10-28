package racingcar.model;

import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.validation.CarNameValidator;

public class CarMaker {

    private static final String SPLITTER = ",";

    private final CarNameValidator carNameValidator;

    public CarMaker(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<Car> makeCars(String carNames) {
        List<String> carNameList = parseCarNames(carNames);
        carNameValidator.validateCarNameList(carNameList);
        return createCars(carNameList);
    }

    private List<String> parseCarNames(String carNames) {
        return Stream.of(carNames.split(SPLITTER))
                .map(String::trim)
                .toList();
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }
}
