package racingcar.validator;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            isLengthValid(carName);
            isContainSpace(carName);
        }
    }

    public void isLengthValid(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void isContainSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    public void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
