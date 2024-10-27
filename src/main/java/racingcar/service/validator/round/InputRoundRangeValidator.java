package racingcar.service.validator.round;

public class InputRoundRangeValidator implements InputRoundValidator {

    @Override
    public void validate(String inputRoundCount) {
        try {
            checkRange(inputRoundCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 1~2,147,483,647까지만 가능합니다.");
        }
    }

    private void checkRange(String inputRoundCount) {
        if (!isInRange(getStringToInteger(inputRoundCount))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInRange(int stringToInteger) {
        return stringToInteger >= 1;
    }

    private int getStringToInteger(String inputRoundCount) {
        return Integer.parseInt(inputRoundCount);
    }
}
