package racingcar.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IncrementNumberTest {

    @Test
    @DisplayName("position 객체 생성시, position 값은 0이다.")
    void givenNothing_whenCreate_thenPositionValueIsZero() {
        // given
        // when
        IncrementNumber incrementNumber = new IncrementNumber();

        // then
        assertThat(incrementNumber.getValue()).isZero();
    }

    @Test
    @DisplayName("position 객체 생성 후 position 값이 증가된다.")
    void givenCreatePosition_whenIncrement_thenPositionValueIsOne() {
        // given
        IncrementNumber incrementNumber = new IncrementNumber();

        // when
        incrementNumber.increment();

        // then
        assertThat(incrementNumber.getValue()).isOne();
    }

}