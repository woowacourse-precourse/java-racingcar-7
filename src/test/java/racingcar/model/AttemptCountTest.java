package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 0, -99, -84})
    void throwExceptionIfAttemptCountIsOutOfRange(int input) {
        Assertions.assertThatThrownBy(() -> new AttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 84})
    void shouldReturnCorrectNumber(int input) {
        AttemptCount attemptCount = new AttemptCount(input);

        Assertions.assertThat(attemptCount.getAttemptCount())
                .isEqualTo(input);
    }
}
