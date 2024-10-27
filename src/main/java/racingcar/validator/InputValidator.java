package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    private static final String NOT_ALLOWED_CHARACTER_REGEX = ".*[^a-zA-Z0-9가-힣].*";
    private static final int MAX_CAR_NAME_RANGE = 5;
    public static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MAX_CAR_NAME_COUNT = 100;
    public static final int MIN_TRIAL_COUNT = 1;
    public static final int MAX_TRIAL_COUNT = 10000;
    public static final String NUMBER_REGEX = "\\d+";

    public void validateCarName(String[] names) {
        validateCarNameLength(names);
        validateCarNameContainsNotAllowedCharacter(names);
        validateCarNameDuplication(names);
        validateCarNameMinCount(names);
        validateCarNameMaxCount(names);
    }

    public void validateTrialCount(String trialCount) {
        validateTrialCountInputType(trialCount);
        validateTrialCountMinCount(trialCount);
        validateTrialCountMaxCount(trialCount);
    }

    private void validateCarNameLength(String[] names) {
        if (Arrays.stream(names).anyMatch(s -> s.length() > MAX_CAR_NAME_RANGE)) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
    }

    private void validateCarNameDuplication(String[] names) {
        if (Arrays.stream(names).distinct().count() < names.length) {
            throw new IllegalArgumentException("같은 이름의 자동차 이름은 허용되지 않습니다.");
        }
    }

    private void validateCarNameMinCount(String[] names) {
        if (names.length < MIN_CAR_NAME_COUNT) {
            throw new IllegalArgumentException("자동차의 최소 개수는 2개 입니다.");
        }
    }

    private void validateCarNameMaxCount(String[] names) {
        if(names.length > MAX_CAR_NAME_COUNT){
            throw  new IllegalArgumentException("자동차 이름의 최대 개수는 100입니다.");
        }
    }

    private void validateCarNameContainsNotAllowedCharacter(String[] names) {
        if (Arrays.stream(names).anyMatch(s -> s.matches(NOT_ALLOWED_CHARACTER_REGEX))) {
            throw new IllegalArgumentException("이름에는 알파벳, 한글, 숫자만 포함 가능합니다.");
        }
    }

    private void validateTrialCountInputType(String trialCount) {
        if (!trialCount.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("시행 횟수는 숫자로만 이루어져야 합니다");
        }
    }

    private void validateTrialCountMinCount(String trialCount) {
        if (Integer.parseInt(trialCount) < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시행 횟수는 0보다 큰 정수여야 합니다.");
        }
    }

    private void validateTrialCountMaxCount(String trialCount) {
        if (Integer.parseInt(trialCount) > MAX_TRIAL_COUNT) {
            throw new IllegalArgumentException("시행 횟수는 10000 이하의 정수여야 합니다.");
        }
    }
}