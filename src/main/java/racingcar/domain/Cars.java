package racingcar.domain;

import racingcar.domain.validator.CarNameValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";
    private final List<Car> cars;

    public Cars(String carNames, CarNameValidator carNameValidator) {
        List<String> convertedStringToList = List.of(carNames.split(COMMA));
        carNameValidator.validate(convertedStringToList);
        this.cars = convertedStringToList.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
