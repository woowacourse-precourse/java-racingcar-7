package racingcar.util;

public class InputValidator {
    private InputValidator() {}

    public static void check(String cars, String count) {
        checkCars(cars);
        checkCount(count);
    }

    private static void checkCars(String cars) {
        if (!cars.matches("^[a-zA-Z가-힣0-9,]+$")) {
            throw new IllegalArgumentException("자동차 이름에는 한글, 영어, 숫자만 가능하고 구분자는 쉼표만 사용할 수 있습니다.");
        }
        if (cars.chars().filter(v -> v == ',').count() >= 1000) {
            throw new IllegalArgumentException("차량 수가 1000대를 초과합니다.");
        }
    }

    private static void checkCount(String count) {
        if (!count.matches("\\d+")) {
            throw new IllegalArgumentException("경주 횟수는 숫자만 입력 가능합니다.");
        }

        if (count.length() > 4 || (count.length() == 4 && count.compareTo("1000") > 0)) {
            throw new IllegalArgumentException("입력값이 1000보다 큽니다.");
        }

        if (count.compareTo("0") <= 0) {
            throw new IllegalArgumentException("최소 경주 횟수는 1 이상 입니다.");
        }
    }
}
