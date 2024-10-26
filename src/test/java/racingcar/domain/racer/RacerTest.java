package racingcar.domain.racer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racer.utils.Condition;

class RacerTest {

    @Test
    @DisplayName("전진할 수 있는 조건일 경우, 자동차는 전진한다.")
    void givenCanForwardCondition_whenForward_thenCarForward() {
        // given
        Racer racer = new Racer("car", new Condition(() -> 4));
        int beforePosition = racer.getPosition();

        // when
        racer.forward();

        // then
        assertThat(racer.getPosition()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("전진할 수 없는 조건일 경우, 자동차는 정지한다.")
    void givenCanNotForwardCondition_whenForward_thenCarStop() {
        // given
        Racer racer = new Racer("car", new Condition(() -> 3));
        int beforePosition = racer.getPosition();

        // when
        racer.forward();

        // then
        assertThat(racer.getPosition()).isEqualTo(beforePosition);
    }

}