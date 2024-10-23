package racingcar;

public class Model {

    String[] getCarNames(String inputString) {
        String[] carNames = inputString.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
            }
        }
    }

    void validateAttemptCount(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시행횟수가 양수가 아닙니다.");
        }
    }
}
