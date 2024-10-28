package racingcar;

public class InputValidator {
    public static void validateTrialInput(String input) {
        try {
            isPositive(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("전진 시도 입력이 숫자가 아닙니다.");
        }
    }

    private static void isPositive(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("전진 시도는 1 이상부터 가능합니다.");

        }
    }

    public static void validateNameInput(String carName) {
        isEmpty(carName);
        isContainBlank(carName);
        isTooLong(carName);

    }

    private static void isTooLong(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름이 5글자를 초과합니다.");
        }
    }

    private static void isContainBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백 문자가 있습니다.");
        }
    }

    private static void isEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }


}
