package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String ERROR_EMPTY_OR_NULL_NAME = "자동차 이름은 빈 문자열이 될 수 없습니다.";
    private static final String ERROR_NAME_LENGTH = "자동차의 이름은 다섯 글자를 넘을 수 없습니다.";
    private static final String ERROR_NAME_ALREADY_EXIST = "중복된 이름이 존재합니다.";
    private static final String ERROR_INVALID_COUNT = "올바른 숫자를 입력해 주세요.";

    public String[] splitNames(String carNameString) {
        validateNameString(carNameString);
        String[] carNames = splitByDelimiter(carNameString);
        String[] trimmedCarNames = trimCarNames(carNames);
        validateCarNames(trimmedCarNames);
        return checkAlreadyExist(trimmedCarNames);
    }

    private String[] trimCarNames(String[] carNames) {
        String[] trimmedCarNames = new String[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            trimmedCarNames[i] = carNames[i].trim();
        }
        return trimmedCarNames;
    }

    private void validateNameString(String carNameString) {
        if (carNameString == null || carNameString.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_OR_NULL_NAME);
        }
    }

    private String[] checkAlreadyExist(String[] trimmedCarNames) {
        Set<String> nameSet = new HashSet<>();
        for (String carName : trimmedCarNames) {
            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException(ERROR_NAME_ALREADY_EXIST);
            }
        }
        return trimmedCarNames;
    }

    private void validateCarNames(String[] trimmedCarNames) {
        for (String trimmedCarName : trimmedCarNames) {
            checkLength(trimmedCarName);
        }
    }

    private String[] splitByDelimiter(String carNameString) {
        return carNameString.split(DELIMITER);
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
