package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void 위치_생성() {
        Position position = new Position();
        assertThat(position).isNotNull();
    }

    @Test
    void 전진() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}