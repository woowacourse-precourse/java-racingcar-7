package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("차의 포지션을 나타내는 값 객체임을 확인하는 테스트하라")
    @Test
    void test1() {
        Position position = new Position(3);

        assertThat(position).isEqualTo(PositionFixture.position(3));
    }

    @DisplayName("자동차의 포지션이 음수이면 예외를 반환함을 테스트하라")
    @Test
    void test2() {
        int position = -1;
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 position 은 음수일 수 없습니다. 현재 포지션: (%d)", position));
    }

    @DisplayName("자동차의 포지션이 우승자 포지션인지 아닌지 판별하는 메서드를 테스트하라")
    @Test
    void test3() {
        Position position = new Position(3);
        int winnerPosition = 3;

        assertThat(position.isWinnerPosition(winnerPosition)).isTrue();
        assertThat(position.isWinnerPosition(2)).isFalse();
    }
}
