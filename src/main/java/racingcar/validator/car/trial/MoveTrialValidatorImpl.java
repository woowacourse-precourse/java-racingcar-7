package racingcar.validator.car.trial;

public class MoveTrialValidatorImpl implements MoveTrialValidator {

    public static final String NUMBER_REGEX = "\\d+";

    @Override
    public void valdate(String trialInputString) {
        if (!trialInputString.matches(NUMBER_REGEX))
            throw new IllegalArgumentException("잘못된 시도 횟수 입력");
    }
}
