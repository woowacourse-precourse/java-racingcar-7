package racingcar.race.manager;

import static racingcar.race.manager.ManagerConstant.MAXIMUM_NAMES_SIZE;
import static racingcar.race.manager.ManagerConstant.MINIMUM_NAMES_SIZE;
import static racingcar.race.manager.ManagerConstant.MINIMUM_ROUND_THRESHOLD;
import static racingcar.race.manager.ManagerConstant.NAME_SIZE_ERROR_MESSAGE;
import static racingcar.race.manager.ManagerConstant.NEGATIVE_NUMBER_ERROR_MESSAGE;

import java.util.List;

public class ValidManager {

    public void validateRange(int round) {
        if (round <= MINIMUM_ROUND_THRESHOLD) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateSize(List<String> names) {
        if (names.size() < MINIMUM_NAMES_SIZE) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }

        if (names.size() > MAXIMUM_NAMES_SIZE) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }
    }
}
