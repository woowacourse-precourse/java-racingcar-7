package racingcar.util;

public class Validation {
    private static final String errorMessage = "사용자가 잘못된 값을 입력하였습니다.";
    private static final int MAX_NAME_LEN = 5;
    public static void validateNames(String carNames[]) {
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LEN) {
                throw new IllegalArgumentException(errorMessage);
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public static void validateNum(String input) {
        int tryNum = Integer.parseInt(input);
        try {
            if (tryNum <= 0) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
