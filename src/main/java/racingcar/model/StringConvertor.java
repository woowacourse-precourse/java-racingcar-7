package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConvertor {

    public List<Car> convertToCarList(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .peek(this::verifyCarNameLength)
                .map(Car::new)
                .toList();
    }

    public String convertToString(List<Car> inputList) {
        return inputList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private void verifyCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 잘못된 이름: " + carName);
        }
    }
}
