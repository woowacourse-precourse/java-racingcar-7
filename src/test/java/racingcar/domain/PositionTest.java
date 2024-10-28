package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;

class PositionTest {

    @Test
    @DisplayName("기본 위치 값은 0이여야 한다.")
    void defaultPositionValueTest() {
        // when
        Position position = Position.defaultValue();

        // then
        assertThat(position.value()).isZero();
    }

    @Test
    @DisplayName("앞으로 1만큼 이동할 수 있어야 한다.")
    void moveForwardTest() {
        // given
        Position position = Position.defaultValue();

        // when
        position.moveForward();

        // then
        assertThat(position.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치는 비교할 수 있어야 한다.")
    void comparePositionTest() {
        // given
        Position zeroPosition = Position.defaultValue();
        Position comparePosition = Position.defaultValue();
        comparePosition.moveForward();

        // when, then
        assertAll(
                () -> assertThat(zeroPosition.compareTo(zeroPosition)).isZero(),
                () -> assertThat(comparePosition.compareTo(zeroPosition)).isOne(),
                () -> assertThat(zeroPosition.compareTo(comparePosition)).isEqualTo(-1)
        );
    }
}
