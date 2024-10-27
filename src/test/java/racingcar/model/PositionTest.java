package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    @DisplayName("Position 객체를 생성한다.")
    void createPosition() {
        // given, when
        Position position = new Position(1);

        // then
        Assertions.assertThat(position).isNotNull();
    }
}