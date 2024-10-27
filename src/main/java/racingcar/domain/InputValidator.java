package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

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
     * 시도 횟수가 정수형 숫자인지 검사
     */
    public static int isIntegerNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
