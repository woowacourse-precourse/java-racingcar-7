package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position 객체 생성시, position 값은 0이다.")
    void givenNothing_whenCreate_thenPositionValueIsZero() {
        // given
        // when
        Position position = new Position();

        // then
        assertThat(position.getValue()).isZero();
    }

    @Test
    @DisplayName("position 객체 생성 후 position 값이 증가된다.")
    void givenCreatePosition_whenIncreasing_thenPositionValueIsOne() {
        // given
        Position position = new Position();

        // when
        position.increasing();

        // then
        assertThat(position.getValue()).isOne();
    }

}