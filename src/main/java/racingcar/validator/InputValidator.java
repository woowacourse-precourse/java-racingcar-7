package racingcar.validator;

public class InputValidator {

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
            }
        }
    }

    public static void validateTrialCount(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}

