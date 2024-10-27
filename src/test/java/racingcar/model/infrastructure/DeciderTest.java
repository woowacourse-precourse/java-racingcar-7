package racingcar.model.infrastructure;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Decider;

import static org.assertj.core.api.Assertions.assertThat;

class DeciderTest {
    @Test
    void 움직일수있는_4이상의_값일때_테스트() {
        // given
        Decider carMoveDecider = CarMoveDecider.getInstance();
        int parameterNumber = 4;
        // when
        System.out.println("=====Logic Start=====");

        boolean actual = carMoveDecider.canMove(parameterNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isTrue();
    }

    @Test
    void 움직일수없는_4미만의_값일때_테스트() {
        // given
        Decider carMoveDecider = CarMoveDecider.getInstance();
        int parameterNumber = 0;
        // when
        System.out.println("=====Logic Start=====");

        boolean actual = carMoveDecider.canMove(parameterNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isFalse();
    }
}