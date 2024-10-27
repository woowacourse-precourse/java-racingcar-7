package racingcar.validator;

public class StringValidator {

    public void isNull(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null 값이 입력되었습니다.");
        }
    }

    public void isBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("비어있는 값이 입력되었습니다.");
        }
    }

    public void isNotNumeric(String string) {
        if (!string.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public void isOutOfIntegerRange(String numericString) {
        try {
            Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Integer 범위를 벗어난 값이 입력되었습니다.");
        }
    }

    public void isZeroOrMinus(String numericString) {
        int intValue = Integer.parseInt(numericString);
        if (intValue <= 0) {
            throw new IllegalArgumentException("0보다 작은 값이 입력되었습니다.");
        }
    }
}
