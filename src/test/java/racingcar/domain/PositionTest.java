package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void Position_생성() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void 전진() {
        Position position = new Position(0);
        assertThat(position.move()).isEqualTo(new Position(1));
    }

    @Test
    void 더_큰_위치값_구하기() {
        Position position = new Position(4);
        assertThat(position.getLargerPosition(3)).isEqualTo(4);
    }

    @Test
    void 같은_위치값인지_판단하기() {
        Position position = new Position(2);
        assertThat(position.isSamePosition(2)).isTrue();
        assertThat(position.isSamePosition(3)).isFalse();
    }

    @Test
    void 전진_횟수_표시하기() {
        Position position = new Position(2);
        assertThat(position.signCount()).isEqualTo("--");
    }
}
