package racingcar.validator;

public class Validator {

    public void validateInputNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력받은 값이 없습니다.");
        }
    }


    public void validateCarNameLength(String[] cars) {
        for (String car : cars) {
            if (car.length() >= 6) {
                throw new IllegalArgumentException("입력받은 자동차 이름의 크기가 6이상 입니다."); //
            }
        }
    }

    public void validateNoEmptyCarNames(String carNames) {
        String[] cars = carNames.split(",", -1);
        for (String car : cars) {
            if (car.trim().isEmpty()) {
                throw new IllegalArgumentException("이름이 없는 자동차가 존재 합니다.");
            }
        }
    }

    public void validatePositiveNumber(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException("음수가 아닌 양수를 입력 해야합니다.");
        }
    }

    public int convertToInteger(String attemptString) {
        try {
            return Integer.parseInt(attemptString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자입니다.");
        }
    }
}
