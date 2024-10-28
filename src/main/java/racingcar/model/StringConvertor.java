package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConvertor {

    public List<Car> convertToCarList(String inputString) {
        List<String> cars = Arrays.stream(inputString.split(",")).toList();
        Verifier.verifyNumberOfCar(cars);
        return cars.stream()
                .map(String::trim)
                .peek(Verifier::verifyCarNameLength)
                .map(Car::new)
                .toList();
    }

    public String convertToString(List<Car> inputList) {
        return inputList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
