package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> validateNames(String input) {
        // 입력값이 비어있거나 공백만 있는 경우 예외 처리
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 각 자동차 이름이 5자를 초과하지 않는지 검사
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    public static int validateMoveCnt(String input) {
        // 입력 이동 횟수가 숫자인지 검증
        try {
            return Integer.parseInt( input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야만 합니다.");
        }
    }
}