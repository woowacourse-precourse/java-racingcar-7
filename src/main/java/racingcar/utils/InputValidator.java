package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_PARTICIPANTS = 20;
    private static final int MAX_ATTEMPTS = 24;
    private static final String NAME_REGEX = "^[a-zA-Z0-9,]+$";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static List<String> validateAndParseCarNames(String input) {
        validateNotEmpty(input);
        String sanitizedInput = removeAllSpaces(input);
        validateInputFormat(sanitizedInput);
        validateCommaUsage(sanitizedInput);

        List<String> carNames = Arrays.asList(sanitizedInput.split(","));
        validateParticipantCount(carNames);
        validateCarNameRules(carNames);

        return carNames;
    }

    public static String validateAttempts(String input) {
        String sanitizedInput = removeAllSpaces(input);
        validateNotEmpty(sanitizedInput);
        validateAttemptsFormat(sanitizedInput);
        validateAttemptsCount(sanitizedInput);
        return sanitizedInput;
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있어서 레이스를 시작할 수 없습니다.");
        }
    }

    private static String removeAllSpaces(String input) {
        return input.trim().replaceAll("\\s", "");
    }

    private static void validateInputFormat(String input) {
        if (!input.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("입력값은 영어 소문자, 대문자, 숫자, 그리고 콤마만 가능합니다.");
        }
    }

    private static void validateAttemptsFormat(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 반드시 숫자만 입력해야 합니다.");
        }
    }


    private static void validateCommaUsage(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("이름 양 끝에 쉼표가 올 수 없습니다.");
        }
        if (input.contains(",,")) {
            throw new IllegalArgumentException("이름 사이에 연속된 쉼표가 올 수 없습니다.");
        }
    }

    private static void validateParticipantCount(List<String> carNames) {
        if (carNames.size() > MAX_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자는 최대 20명까지만 허용됩니다.");
        }
    }

    private static void validateAttemptsCount(String input) {
        int attemptsCount = Integer.parseInt(input);
        if (attemptsCount > MAX_ATTEMPTS || attemptsCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상 24 이하여야 합니다.");
        }
    }

    private static void validateCarNameRules(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다: " + name);
            }
        }
    }

}
