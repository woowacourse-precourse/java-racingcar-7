package racingcar.game.controller.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름의 길이는 5를 넘을 수 없습니다.";
    private static final String UNSUPPORTED_ATTEMPT_COUNT_TYPE = "시도할 횟수는 문자일 수 없습니다.";

    public List<String> getCarNamesFromUser() {
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(NAME_SPLIT_DELIMITER))
                .peek(this::validateCarNameLength)
                .toList();
    }

    public int getAttemptCountFromUser() {
        String attemptCount = Console.readLine();
        return parseAsInteger(attemptCount);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    private int parseAsInteger(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UNSUPPORTED_ATTEMPT_COUNT_TYPE);
        }
    }
}