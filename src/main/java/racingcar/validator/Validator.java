package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MAX_ROUND_COUNT = 10000;

    private static final String NAME_DELIMITER = ",";

    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]+$";

    private static final String VALIDATE_NAME_PATTERN_MSG = "자동차 이름 입력 형식은 , 단위로 작성해주십시오";
    private static final String MAX_NAME_SIZE_MSG = "이름은 최대 5자까지 가능합니다.";
    private static final String VALIDATE_POSITIVE_INTEGER_MSG = "이동 횟수는 0 이상의 정수만 가능합니다.";
    private static final String DUPLICATE_NAME_MSG = "자동차 이름은 중복될 수 없습니다.";
    private static final String MINIMUM_CAR_COUNT_MSG = "최소한 두 대 이상의 자동차가 필요합니다.";
    private static final String MAX_ROUND_LIMIT_DUE_TO_PERFORMANCE = "성능의 문제상 최대 라운드인 10000 라운드를 넘을 수 없습니다.";
    //이름 중복
    public void validateAllInput(String inputCarNames, String inputCarRoundCount) {
        validateDelimitedNameFormat(inputCarNames);
        validateDuplicateNames(inputCarNames);
        validateNameLengthWithinLimit(inputCarNames);
        validateRoundCountAsPositiveInteger(inputCarRoundCount);
        validateCarCountAboveMinimum(inputCarNames);
        validateRoundCountWithinLimit(inputCarRoundCount);
    }

    private void validateDelimitedNameFormat(String input) {
        if (!input.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(VALIDATE_NAME_PATTERN_MSG);
        }
    }

    private void validateDuplicateNames(String input) {
        String[] names = input.split(NAME_DELIMITER);
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_MSG);
            }
        }
    }

    private void validateNameLengthWithinLimit(String input) {
        String[] names = input.split(NAME_DELIMITER);
        for (String name : names) {
            if (name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(MAX_NAME_SIZE_MSG);
            }
        }
    }

    private void validateRoundCountAsPositiveInteger(String inputCarRoundCount) {
        if (!inputCarRoundCount.matches(POSITIVE_INTEGER_PATTERN)) {
            throw new IllegalArgumentException(VALIDATE_POSITIVE_INTEGER_MSG);
        }
    }

    private void validateCarCountAboveMinimum(String input) {
        String[] names = input.split(NAME_DELIMITER);
        if (names.length < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(MINIMUM_CAR_COUNT_MSG);
        }
    }

    private void validateRoundCountWithinLimit(String inputCarRoundCount) {
        int roundCount = Integer.parseInt(inputCarRoundCount);
        if (roundCount > MAX_ROUND_COUNT) {
            throw new IllegalArgumentException(MAX_ROUND_LIMIT_DUE_TO_PERFORMANCE);
        }
    }
}
