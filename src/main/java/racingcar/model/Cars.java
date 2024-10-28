package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.ErrorMessages;

public class Cars {
    private static final String DELIMITER_COMMA = ",";
    private static final int MIN_LIST_SIZE = 2;
    private final List<Car> carList;

    public Cars(String carNames) {
        List<String> carNameList = convertCarNamesToList(carNames);
        validateListSize(carNameList);
        validateNoDuplicateNames(carNameList);
        this.carList = carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private static List<String> convertCarNamesToList(String input) {
        return Arrays.asList(input.split(DELIMITER_COMMA));
    }

    public void validateListSize(List<String> carNames) {
        if (carNames.size() < MIN_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_LIST_SIZE);
        }
    }

    public void validateNoDuplicateNames(List<String> carNames) {
        long distinctCount = carNames.stream()
                .distinct()
                .count();
        if (carNames.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME);
        }
    }
}
