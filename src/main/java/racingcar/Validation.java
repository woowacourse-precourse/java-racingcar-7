package racingcar;

public class Validation {
    public static int validateNumber(String inputNumber) {
        int num;
        try {
            num = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (num < 0) {
            throw new IllegalArgumentException("음수 입니다.");
        }
        return num;

    }
}
