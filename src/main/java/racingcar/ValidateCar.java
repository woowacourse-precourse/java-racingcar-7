package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ValidateCar {
    public static List<String> firstParsingOnComma(String userInput) {

        validateEmptyInput(userInput);
        validateExtraComma(userInput);

        List<String> list = new ArrayList<>();

        for (String part : userInput.split(",")) {
            String trimmedPart = part.trim();
            validateEmptyPart(trimmedPart);
            validateNameLength(trimmedPart);
            list.add(trimmedPart);
        }
        return list;
    }

    private static void validateEmptyInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateExtraComma(String userInput) {
        String[] splitCarNames = userInput.split(",");
        if (splitCarNames.length == 0) {
            throw new IllegalArgumentException("쉼표가 여러개 입력되었습니다.");
        }
    }

    private static void validateEmptyPart(String part) {
        if (part.isEmpty()) {
            throw new IllegalArgumentException("쉼표 뒤에 이름이 들어오지 않았습니다.");
        }
    }

    private static void validateNameLength(String part) {
        if (part.length() > 5) {
            throw new IllegalArgumentException("이름이 5자를 초과합니다.");
        }
    }
}
