package racingcar;

public class TryNumbersValidator {
    public static void validateNumeric(String tryNums) {
        for (char num : tryNums.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자가 아닌 값은 올 수 없습니다.");
            }
        }
    }

}
