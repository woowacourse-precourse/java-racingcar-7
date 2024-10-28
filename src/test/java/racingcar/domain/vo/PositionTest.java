package racingcar.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void 생성된_position_value_확인() {
        // given
        final Position position = new Position(4);

        // when
        final Integer value = position.getValue();

        // then
        assertThat(value).isEqualTo(4);
    }

    @Test
    void Position_객체가_불변성을_유지하는지_확인() {
        // given
        Position position = new Position(0);

        // when
        Position newPosition = position.move();

        // then
        assertAll(
            () -> assertThat(position.getValue()).isEqualTo(0),
            () -> assertThat(newPosition.getValue()).isEqualTo(1),
            () -> assertThat(position).isNotEqualTo(newPosition)
        );

    }
}