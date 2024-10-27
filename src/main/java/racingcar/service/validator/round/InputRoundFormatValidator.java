package racingcar.service.validator.round;

public class InputRoundFormatValidator implements InputRoundValidator {
    private static final String NUMBER_EXPRESSION = "^[0-9]+$";

    @Override
    public void validate(String inputRoundCount) {
        if (!isNumber(inputRoundCount)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    private boolean isNumber(String inputRoundCount) {
        return inputRoundCount.matches(NUMBER_EXPRESSION);
    }
}
