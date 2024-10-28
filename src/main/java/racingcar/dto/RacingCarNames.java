package racingcar.dto;

import static racingcar.exception.ErrorMessage.*;

import racingcar.exception.RacingCarException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record RacingCarNames(List<String> carNames) {

    public static RacingCarNames from(String input) {
        List<String> carNames = Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateInput(carNames);
        return new RacingCarNames(carNames);
    }

    private static void validateInput(List<String> carNames) {
        validateMinimumTwoCars(carNames);
        validateEachCarName(carNames);
    }

    private static void validateMinimumTwoCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw RacingCarException.from(MINIMUM_TWO_CARS_REQUIRED);
        }
    }

    private static void validateEachCarName(List<String> carNames) {
        carNames.forEach(RacingCarNames::validateSingleCarName);
    }

    private static void validateSingleCarName(String carName) {
        validateCarNameCharacters(carName);
        validateCarNameLength(carName);
    }

    private static void validateCarNameCharacters(String carName) {
        if (!isEnglishOnly(carName) && !isKoreanOnly(carName)) {
            throw RacingCarException.from(ONLY_ENGLISH_OR_KOREAN_ALLOWED);
        }
    }

    private static boolean isEnglishOnly(String carName) {
        return carName.matches("^[a-zA-Z]+$");
    }

    private static boolean isKoreanOnly(String carName) {
        return carName.matches("^[가-힣]+$");
    }


    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw RacingCarException.from(NAME_MAX_LENGTH_LIMIT);
        }
    }
}
