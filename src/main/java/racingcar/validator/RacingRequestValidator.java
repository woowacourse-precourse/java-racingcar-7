package racingcar.validator;

import java.util.List;
import racingcar.dto.request.RacingRequestDTO;

public final class RacingRequestValidator {
    private final static String BLANK_CAR_NAME_MESSAGE = "자동차 이름이 비어있습니다.";
    private final static String CAR_NAME_TOO_LONG_MESSAGE = "자동차 이름 %d자 초과 되었습니다.";
    private final static Integer MAX_CAR_NAME_LENGTH = 5;
    private final static String INVALID_MOVE_COUNT_MESSAGE = "이동 횟수는 %d 이상이어야 합니다.";
    private final static Integer MIN_MOVE_COUNT = 1;

    private RacingRequestValidator() {
    }

    public static void validate(RacingRequestDTO racingRequestDTO) {
        validateCarNames(racingRequestDTO.carNames());
        validateMoveCount(racingRequestDTO.moveCount());
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(BLANK_CAR_NAME_MESSAGE);
        }
        if (carNames.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException(
                    String.format(CAR_NAME_TOO_LONG_MESSAGE, MAX_CAR_NAME_LENGTH)
            );
        }
    }

    private static void validateMoveCount(Integer moveCount) {
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException(
                    String.format(INVALID_MOVE_COUNT_MESSAGE, MIN_MOVE_COUNT)
            );
        }
    }
}
