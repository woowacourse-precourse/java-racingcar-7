package racingcar;

public class ExceptionHandler {
    public static String validateCarName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1자에서 5자 사이여야 합니다.");
        }
        return name;
    }

    public static int validateNaturalNum(String value) {
        int num;

        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자형 문자를 입력해주세요.");
        }
        checkNegative(num);
        return num;
    }

    private static void checkNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("입력값이 음수입니다.");
        }
    }
}
