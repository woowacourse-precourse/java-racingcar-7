package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessages;

public class CarList extends ArrayList<Car> {
    private static final String DELIMITER_COMMA = ",";
    private static final int MIN_LIST_SIZE = 2;

    public CarList(String carNames) {
        List<Car> carList = convertCarNamesToList(carNames);
        validateListSize(carList);
        validateNoDuplicateNames(carList);
        super.addAll(carList);
    }

    public List<Car> convertCarNamesToList(String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .toList();
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER_COMMA, -1));
    }

    private void validateListSize(List<Car> carList) {
        if (carList.size() < MIN_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_LIST_SIZE);
        }
    }

    private void validateNoDuplicateNames(List<Car> carList) {
        long distinctCount = carList.stream()
                .distinct()
                .count();
        if (carList.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME);
        }
    }
}
