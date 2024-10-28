package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int NAME_MAX_BOUNDS = 5;
    private static final String NAME_DELIMITER = ",";

    public void validateCarNames(String inputNames) {
        checkNameBounds(inputNames);
        checkDuplicateName(inputNames);
        checkDelimiter(inputNames);
    }

    public void validateRoofCount(String inputCount) {
        isNumeric(inputCount);
    }

    /* Car Name */
    private static void checkNameBounds(String inputNames) {
        String[] carNames = inputNames.split(NAME_DELIMITER);

        for (String carName : carNames) {
            if (carName.length() > NAME_MAX_BOUNDS) {
                throw new IllegalArgumentException("자동차 이름의 최대길이는 5글자 입니다");
            }
        }
    }

    private static void checkDuplicateName(String inputNames) {
        List<String> carNames = Arrays.stream(inputNames.split(NAME_DELIMITER))
                .toList();

        boolean hasDuplicate = carNames.stream()
                .distinct()
                .count() != carNames.size();

        if (hasDuplicate) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다");
        }
    }

    private static void checkDelimiter(String inputNames) {
        String[] carNames = inputNames.split(NAME_DELIMITER);

        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백을 허용하지 않습니다");
            }

            if (carName.contains(NAME_DELIMITER)) {
                throw new IllegalArgumentException("잘못된 구분자를 사용하였습니다");
            }
        }
    }

    /* Roof Count */
    private void isNumeric(String input) {
        boolean isNumber = input.chars()
                .allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException("숫자만 입력될 수 있습니다");
        }
    }
}

