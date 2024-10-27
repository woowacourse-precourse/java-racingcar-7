package racingcar.validator;

public class InputStringValidator {
    public static void carNameIsEmpty(String userInputCarNameString) {
        if(userInputCarNameString.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
    }

    public static void attemptCountIntegratedValidation(String userInputAttemptCount) {
        attemptCountIsEmpty(userInputAttemptCount);
        attemptCountIsNotNumber(userInputAttemptCount);
        attemptCountIsNegativeNumber(userInputAttemptCount);
    }

    private static void attemptCountIsEmpty(String userInputAttemptCount) {
        if(userInputAttemptCount.isEmpty()) throw new IllegalArgumentException("시도할 횟수가 입력되지 않았습니다.");
    }

    private static void attemptCountIsNotNumber(String userInputAttemptCount) {
        try {
            Integer.parseInt(userInputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력되어야 합니다.");
        }
    }

    private static void attemptCountIsNegativeNumber(String userInputAttemptCount) {
        if (Integer.parseInt(userInputAttemptCount) < 0) throw new IllegalArgumentException("0 이상의 숫자를 입력해 주세요.");
    }
}
