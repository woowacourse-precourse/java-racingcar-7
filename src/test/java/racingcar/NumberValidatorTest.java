package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
    @DisplayName("전달받은 값이 4 미만이면 false 반환")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 3})
    void returnFalseIf4IsGreaterThan(int value) {
        boolean actual = new NumberValidator().isAboveLowerBound(value);

        assertThat(actual).isFalse();
    }

    @DisplayName("전달받은 값이 4 이상이면 true 반환")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 100})
    void returnTrueIf4IsLessThanOrEqual(int value) {
        boolean actual = new NumberValidator().isAboveLowerBound(value);

        assertThat(actual).isTrue();
    }
}