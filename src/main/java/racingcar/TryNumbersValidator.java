package racingcar;

public class TryNumbersValidator {

    public Long validate(String tryNums) {
        validateBlank(tryNums);
        validateNumeric(tryNums);
        return Long.parseLong(tryNums);
    }

    public void validateNumeric(String tryNums) {
        for (char num : tryNums.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("시도 횟수는 0-9 사이의 정수만 허용됩니다.");
            }
        }
    }

    public void validateBlank(String tryNums) {
        if (tryNums.isBlank()) {
            throw new IllegalArgumentException("공백 값은 허용하지 않습니다.");
        }
    }

}
