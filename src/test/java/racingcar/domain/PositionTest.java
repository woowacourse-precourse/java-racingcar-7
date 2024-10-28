package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    private final Position POSITION_AT_ONE = new Position(1);

    @Test
    void Position_생성() {
        assertThat(POSITION_AT_ONE).isEqualTo(new Position(1));
    }

    @Test
    void 더_큰_위치값_구하기() {
        assertThat(POSITION_AT_ONE.getMax(2)).isEqualTo(2);
    }

    @Test
    void 같은_위치인지_판단하기() {
        assertThat(POSITION_AT_ONE.isSame(1)).isTrue();
        assertThat(POSITION_AT_ONE.isSame(3)).isFalse();
    }

    @Test
    void 증가() {
        assertThat(POSITION_AT_ONE.increase()).isEqualTo(new Position(2));
    }

    @Test
    void 전진_횟수_표시하기() {
        assertThat(POSITION_AT_ONE.currentState()).isEqualTo("-");
    }
}
