package racingcar.racingcar;

import static racingcar.constant.Strings.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarValidator {
    private static final RacingCarValidator RACING_CAR_VALIDATOR = new RacingCarValidator();

    private RacingCarValidator() {

    }

    public static RacingCarValidator getInstance() {
        return RACING_CAR_VALIDATOR;
    }

    public void existCheck(String joinedCarNames) {
        if (joinedCarNames.isBlank()) {
            throw new IllegalArgumentException(MORE_THAN_ONE.getMessage());
        }
    }

    public void lengthCheck(List<String> carNames, int maxLength) {
        for (String name : carNames) {
            if (name.length() > maxLength) {
                throw new IllegalArgumentException(OVER_MAX_LENGTH.getMessage());
            }
        }
    }

    public void sameNameCheck(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException(EXIST_SAME_NAME.getMessage());
        }
    }
}
