package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String ERROR_NAME_LENGTH = "자동차의 이름은 다섯 글자를 넘을 수 없습니다.";
    private static final String ERROR_NAME_ALREADY_EXIST = "중복된 이름이 존재합니다.";
    private static final String ERROR_INVALID_COUNT = "올바른 숫자를 입력해 주세요.";

    public String[] splitNames(String carNameString) {
        String[] carNames = splitByDelimiter(carNameString);
        validateCarNames(carNames);
        return checkAlreadyExist(carNames);
    }

    private String[] checkAlreadyExist(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException(ERROR_NAME_ALREADY_EXIST);
            }
        }
        return nameSet.toArray(new String[0]);
    }

    private void validateCarNames(String[] carNames) {
        for (String car : carNames) {
            String trimmedCarName = trimCarName(car);
            checkLength(trimmedCarName);
        }
    }

    private String[] splitByDelimiter(String carNameString) {
        return carNameString.split(DELIMITER);
    }

    private String trimCarName(String car) {
        return car.trim();
    }

    private void checkLength(String trimmedCarName) {
        if (trimmedCarName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public int isValidCount(String raceCountString) {
        validateCount(raceCountString);
        return toInt(raceCountString);
    }

    private int toInt(String raceCountString) {
        return Integer.parseInt(raceCountString);
    }

    private void validateCount(String raceCountString) {
        if (raceCountString == null || raceCountString.isBlank() || !raceCountString.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }
}
