package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.validator.CarNameValidator;

public class Cars {
    private static final String COMMA = ",";
    private final List<Car> cars;

    public Cars(String carNames, CarNameValidator carNameValidator) {
        List<String> toList = List.of(carNames.split(COMMA));
        carNameValidator.validate(toList);
        this.cars = toList.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
