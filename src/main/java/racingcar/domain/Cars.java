package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";
    private final List<Car> cars;

    public Cars(String carNames, CarNameValidator validator) {
        List<String> convertedStringToList = convertStringToList(carNames);
        validator.validate(convertedStringToList);
        this.cars = convertedStringToList.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> convertStringToList(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    public List<Car> getCars() {
        return cars;
    }
}
