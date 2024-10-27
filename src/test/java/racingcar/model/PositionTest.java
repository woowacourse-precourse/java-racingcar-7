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

    @Test
    @DisplayName("같은 값을 가지는 position 객체는 동등성을 보장받는다.")
    void equalsPosition() {
        // given
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        // when, then
        Assertions.assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("Position 객체 간의 크기를 비교할 수 있다.")
    void comparePosition() {
        // given
        Position position1 = new Position(1);
        Position position2 = new Position(2);

        // when, then
        Assertions.assertThat(position2.isBiggerOrEqualTo(position1)).isTrue();
    }
}