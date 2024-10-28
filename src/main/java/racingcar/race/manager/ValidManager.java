package racingcar.race.manager;

import java.util.List;

public class ValidManager {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "1 이상의의 숫자를 입력해야합니다.";
    private static final String NAME_SIZE_ERROR_MESSAGE = "2개 이상 5개 이하로 제한하고 있습니다.";

    private static final int MINIMUM_ROUND_THRESHOLD = 0;

    private static final int MAXIMUM_NAMES_SIZE = 5;
    private static final int MINIMUM_NAMES_SIZE = 2;

    public void validateRange(int round) {
        if (round <= MINIMUM_ROUND_THRESHOLD) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateSize(List<String> names) {
        if (names.size() < MINIMUM_NAMES_SIZE || names.size() > MAXIMUM_NAMES_SIZE) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }
    }
}
