package racingcar;

import java.util.List;

public class GameValidator {

    private final static int MAX_CAR_NAMES_SIZE = 50;
    private final static int MAX_GAME_REPEATS_SIZE = 100;

    public static void validate(List<String> carNamesList, int gameRepeats) {
        validateMaxCarNamesListSize(carNamesList);
        validateMinCarNamesListSize(carNamesList);
        validateMaximumGameRepeats(gameRepeats);
    }

    private static void validateMaxCarNamesListSize(List<String> carNamesList) {
        if (carNamesList.size() > MAX_CAR_NAMES_SIZE) throw new IllegalArgumentException("자동차는 " + MAX_CAR_NAMES_SIZE + "대 이하만 참가 가능합니다");
    }

    private static void validateMinCarNamesListSize(List<String> carNamesList) {
        if (carNamesList.isEmpty()) throw new IllegalArgumentException();

    }

    private static void validateMaximumGameRepeats(int gameRepeats) {
        if (gameRepeats > MAX_GAME_REPEATS_SIZE) throw new IllegalArgumentException("시도할 횟수는 " + MAX_GAME_REPEATS_SIZE + "번 이하만 가능합니다");
    }

}
