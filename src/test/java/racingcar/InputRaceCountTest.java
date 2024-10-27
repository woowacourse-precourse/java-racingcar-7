package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.model.RaceCount;

public class InputRaceCountTest {
    private static final String RACE_TIMES_ALPHABET = "abc";
    private static final String RACE_TIMES_KOREAN = "가나다";
    private static final String RACE_TIMES_ZERO = "0";
    private static final String RACE_TIMES_NEGATIVE_NUMBER = "-3";
    private static final String RACE_TIMES_REAL_NUMBER = "3.3";

    @DisplayName("시도 횟수가 문자를 포함하는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {RACE_TIMES_ALPHABET, RACE_TIMES_KOREAN,
            RACE_TIMES_NEGATIVE_NUMBER, RACE_TIMES_REAL_NUMBER})
    public void ThrowExceptionIfRaceTimesHasCharacters(String raceTimes) {
        Throwable thrown = catchThrowable(() -> {
            RaceCount.hasCharacters(raceTimes);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 이외의 문자가 포함되어 있습니다.");
    }

    @DisplayName("시도 횟수가 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void ThrowExceptionIfRaceTimesEmpty(String raceTimes) {
        Throwable thrown = catchThrowable(() -> {
            RaceCount.isBlank(raceTimes);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 빈 값이 될 수 없습니다.");
    }

    @DisplayName("시도 횟수가 0이면 예외 발생")
    @Test
    public void ThrowExceptionIfRaceTimesZero() {
        Throwable thrown = catchThrowable(() -> {
            RaceCount.isZero(RACE_TIMES_ZERO);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0이 될 수 없습니다.");
    }
}
