package racingcar.validator;

public class Validator {

    public void validateInputNotBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("입력받은 자동차 이름이 없습니다.");
        }
    }
}
