package racingcar.model.registration;

import java.util.Arrays;
import java.util.List;

public class RegistrationValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String POSSIBLE_NAME_REGEX = "[a-zA-Z0-9]+";
    protected static final String SEPARATOR = ",";
    private static final String ONLY_DIGITS_REGEX = "\\d+";
    private static final int MIN_RACE_ROUND_COUNT = 1;

    public static void validateRawInputCarNames(String rawInputCarNames) {
        List<String> carNames = splitRawInput(rawInputCarNames);
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    protected static List<String> splitRawInput(String rawInputCarNames) {
        return Arrays.stream(rawInputCarNames.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }

    private static void validateCarName(String carName) {
        if (isNullOrEmpty(carName)) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상 5자 이하만 가능해요.");
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 최대 5자까지 가능해요.");
        }
        if (containsInvalidCharacters(carName)) {
            throw new IllegalArgumentException("자동차의 이름에는 알파벳과 숫자만 사용할 수 있어요.");
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean containsInvalidCharacters(String input) {
        return !input.matches(POSSIBLE_NAME_REGEX);
    }

    public static void validateRawInputRaceRoundCount(String rawInputRaceRoundCount) {
        if (isNullOrEmpty(rawInputRaceRoundCount)) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
        if (!isNumeric(rawInputRaceRoundCount)) {
            throw new IllegalArgumentException("시도할 횟수에 숫자가 아닌 값을 입력했어요. 1 이상의 숫자를 입력해주세요.");
        }

        int raceRoundCount = parseInteger(rawInputRaceRoundCount);
        if (raceRoundCount < MIN_RACE_ROUND_COUNT) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 해요.");
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(ONLY_DIGITS_REGEX);
    }

    protected static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 시도 횟수가 너무 커요. 1 이상의 적절한 숫자를 입력해주세요.");
        }
    }
}
