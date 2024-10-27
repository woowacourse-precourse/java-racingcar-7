package racingcar;

public class ValidateTryNums {
    public static void isNumeric(String tryNums) {
        for (char num : tryNums.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자가 아닌 값은 올 수 없습니다.");
            }
        }
    }

}
