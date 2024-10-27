package racingcar.validation;

public class ValidateException {

    public void isCarNameValid(String carName) {
        isCarNameEmpty(carName);
        isCarNameLengthValid(carName);
    }

    public String isTryCountValid(String tryCount) {
        isTryCountEmpty(tryCount);
        isTryCountNumber(tryCount);
        isTryCountPositive(tryCount);
        return tryCount;
    }

    private void isCarNameEmpty(String validateValue) {
        if (validateValue.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void isCarNameLengthValid(String validateValue) {
        if (validateValue.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void isTryCountEmpty(String validateValue) {
        if (validateValue.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        }
    }

    private void isTryCountNumber(String validateValue) {
        try {
            Integer.parseInt(validateValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void isTryCountPositive(String validateValue) {
        if (Integer.parseInt(validateValue) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}
