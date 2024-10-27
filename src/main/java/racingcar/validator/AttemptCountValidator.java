package racingcar.validator;

public class TryCountValidator {

    public boolean validate(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }

        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        return true;
    }
}
