package racingcar.model.number;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @DisplayName("전진 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isForward(int input) {
        // given
        Number number = new Number(input);

        // when
        boolean result = number.isGreaterThanForwardThreshold();

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("전진 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void isStop(int input) {
        // given
        Number number = new Number(input);

        // when
        boolean result = number.isGreaterThanForwardThreshold();

        // then
        assertThat(result).isFalse();
    }
}