package racingcar.console;

import java.util.Arrays;
import java.util.HashSet;

final class InputValidator {
    private static final int PLAYER_MIN_SIZE = 2;
    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final int TOTAL_LAPS_MIN_SIZE = 1;

    private InputValidator() {
    }

    public static InputValidator init() {
        return new InputValidator();
    }

    public void validLastString(final String value) {
        if (value.charAt(value.length() - 1) == ',') {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    public void validPlayerList(final String[] value) {
        this.validPlayerDuplicate(value);
        this.validPlayerListSize(value);
        this.validPlayerNameSize(value);
    }

    public void validTotalLapCount(final Long count) {
        if (count < TOTAL_LAPS_MIN_SIZE) {
            throw new IllegalArgumentException("최소 1바퀴 이상");
        }
    }

    private void validPlayerDuplicate(final String[] value) {
        final var uniqueValues = new HashSet<>(Arrays.asList(value));
        if (uniqueValues.size() != value.length) {
            throw new IllegalArgumentException("중복 참가자");
        }
    }

    private void validPlayerListSize(final String[] value) {
        if (value.length < PLAYER_MIN_SIZE) {
            throw new IllegalArgumentException("최소 2명 이상 참여");
        }
    }

    private void validPlayerNameSize(final String[] value) {
        if (Arrays.stream(value).anyMatch(e -> e.length() > PLAYER_NAME_MAX_SIZE)) {
            throw new IllegalArgumentException("플레이어의 이름은 최대 5글자");
        }
    }
}