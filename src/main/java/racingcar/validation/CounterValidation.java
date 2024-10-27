package racingcar.validation;

public class CounterValidation {

    public static int validation(String count) {
        try {
            int positiveCount = Integer.parseInt(count);
            positiveValidate(positiveCount);
            return positiveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void positiveValidate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }
}
