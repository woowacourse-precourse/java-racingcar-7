package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

    /**
     * 자동차 이름의 유효성 검사
     */
    public static List<String> isValidCarName(String input) {
        checkEmptyOrBlank(input);
        List<String> cars = splitCarName(input);
        checkValidLength(cars);
        return cars;
    }

    /**
     * 문자열을 쉼표(,)를 구분자로 하여 분리
     */
    public static List<String> splitCarName(String input) {
        List<String> cars = Stream.of(input.split(",")).collect(Collectors.toList());
        return cars;
    }

    /**
     * 자동차 이름이 5자 이하인지 검사
     */
    public static void checkValidLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 시도 횟수의 유효성 검사
     */
    public static int isValidAttemptNumber(String input) {
        checkEmptyOrBlank(input);
        int attemptNumber = isIntegerNumber(input);
        return attemptNumber;
    }

    /**
     * 시도 횟수가 정수형 숫자인지 검사
     */
    public static int isIntegerNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 문자열이 빈값이거나 공백인지 검사
     */
    public static void checkEmptyOrBlank(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
