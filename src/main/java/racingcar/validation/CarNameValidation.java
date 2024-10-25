package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidation {
    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIncludeComma(input);

        validateCarName(input);
        // 쉼표 기준으로 split -> size 1이면 예외처리
        // 빈문자열이면 무시
        // 띄어쓰기 없애고
        // 5글자 이하인지
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIncludeComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(String input) {
        if (input.length() > 5 || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarName(String input) {
        String[] carNames = input.replaceAll("\\s+", "").split(","); // 공백 처리 완료

        Set<String> carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            validateCarNameLength(carName);
            carNamesSet.add(carName);
        }
    }

}
