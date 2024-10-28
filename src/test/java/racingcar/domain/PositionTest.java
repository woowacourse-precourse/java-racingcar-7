package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.newInstance();
    }

    @Test
    void 포지션은_초기값이_0이다() {
        assertThat(position.position()).isEqualTo(0);
    }

    @Test
    void 포지션을_증가시킬수_있다() {
        position = position.increment();
        assertThat(position.position()).isEqualTo(1);
    }
}