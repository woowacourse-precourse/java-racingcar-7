package racingcar.validator;

public class ValidateCarNames {
    public void isBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
    }
}
