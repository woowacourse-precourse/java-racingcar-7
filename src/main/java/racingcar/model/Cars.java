package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessages;

public class Cars {
    private static final String DELIMITER_COMMA = ",";
    private static final int MIN_LIST_SIZE = 2;
    private final List<Car> carList;

    public Cars(String carNames) {
        List<Car> tempCarList = convertCarNamesToList(carNames).stream()
                .map(Car::new)
                .toList();
        validateListSize(tempCarList);
        validateNoDuplicateNames(tempCarList);
        this.carList = tempCarList;
    }

    private static List<String> convertCarNamesToList(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER_COMMA));
    }

    public void validateListSize(List<Car> carList) {
        if (carList.size() < MIN_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_LIST_SIZE);
        }
    }

    public void validateNoDuplicateNames(List<Car> carList) {
        long distinctCount = carList.stream()
                .distinct()
                .count();
        if (carList.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME);
        }
    }
}
