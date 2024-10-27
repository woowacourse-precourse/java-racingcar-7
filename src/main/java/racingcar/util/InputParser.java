package racingcar.util;

import java.util.List;
import racingcar.exception.ErrorStatus;
import racingcar.exception.ExceptionUtils;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_ROUND = 100;

    public List<String> parseCars(String input) {
        validateInput(input, ErrorStatus.EMPTY_INPUT);

        List<String> carNames = List.of(input.split(DEFAULT_DELIMITER));
        carNames.forEach(this::validateCarName);
        return carNames;
    }

    public int parseRound(String input) {
        validateInput(input, ErrorStatus.EMPTY_INPUT);

        try {
            int round = Integer.parseInt(input);
            validateRound(round);
            return round;
        } catch (NumberFormatException e) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.INVALID_ROUND_INPUT);
        }
        return 0;
    }

    private void validateInput(String input, ErrorStatus errorStatus) {
        if (input == null || input.isEmpty()) {
            ExceptionUtils.throwIllegalArgumentException(errorStatus);
        }
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.INVALID_CAR_NAME);
        }
    }

    private void validateRound(int round) {
        if (round < 1 || round > MAX_ROUND) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.ROUND_OUT_OF_BOUND);
        }
    }
}
