package racingcar.application.validation;

public class CountValidator implements Validator {

    @Override
    public void validate(String string) {
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IllegalArgumentException("횟수를 입력해주세요.");
        }

        string = string.trim();

        if (!string.matches("\\d*")) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }

        int value = Integer.parseInt(string);
        if (value <= 0 || value >= 51) {
            throw new IllegalArgumentException("1이상 50이하의 정수만 입력 가능합니다.");
        }
    }
}
