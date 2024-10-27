package racingcar.validator;

public class NumberValidator{

    public static void validateNumericValue(String input) {
        isNumericValue(input);
        isPositiveInteger(input);
    }

    public static void isNumericValue(String input) {
        try {
            int convert = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값이 아닙니다: " + input);
        }
    }

    public static void isPositiveInteger(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("양의 정수 값이 아닙니다: " + input);
        }
    }

    public static boolean isNumberOverFour(int input) {
        return input >= 4;
    }
}
