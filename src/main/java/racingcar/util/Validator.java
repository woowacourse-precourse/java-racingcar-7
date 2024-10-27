package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.config.GameConfig;

public class Validator {
    private Validator() {
        // 인스턴스화 방지
    }

    private static void validateCarNameFormat(String name) {
        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException(ValidationError.CAR_NAME_NOT_CONTAINS_SPACE.getMessage());
        }
    }

    public static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ValidationError.CAR_NAME_NOT_EMPTY.getMessage());
        }
        if (name.length() > GameConfig.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ValidationError.CAR_NAME_TOO_LONG.getMessage(GameConfig.MAX_NAME_LENGTH));
        }
    }

    private static void validateCarNamesFormat(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ValidationError.CAR_NAME_NOT_EMPTY.getMessage());
        }

        String[] splitNames = input.split(",");
        for (String name : splitNames) {
            validateCarNameFormat(name);
        }
    }

    public static void validateCarNames(List<String> carNames, String input) {
        // 자동차가 한 대일 때 쉼표 검증
        if (carNames.size() == 1 && input.contains(",")) {
            throw new IllegalArgumentException(ValidationError.SINGLE_CAR_WITH_COMMA.getMessage());
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException(ValidationError.DUPLICATE_CAR_NAME.getMessage());
        }

        for (String name : carNames) {
            validateCarName(name);
        }
        validateCarNamesFormat(input);
    }

    public static void validateTrialNumber(String trialNumber) {
        if (trialNumber == null || trialNumber.isEmpty()) {
            throw new IllegalArgumentException(ValidationError.TRAIL_NUMBER_NOT_EMPTY.getMessage());
        }

        int trialCount;
        try {
            trialCount = Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationError.TRIAL_NUMBER_NOT_NUMERIC.getMessage());
        }

        if (trialCount <= 0) {
            throw new IllegalArgumentException(ValidationError.TRIAL_NUMBER_TOO_LOW.getMessage());
        }
    }
}
