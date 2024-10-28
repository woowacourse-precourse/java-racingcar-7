package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름_중복_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Racing.of("pobi,pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Racing.of("pobi,a,b,c,d,pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
            ;
        });
    }

    @Test
    void 경주_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    Racing racing = Racing.of("pobi,woni");
                    racing.runRound();
                    assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(1);
                    assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    Racing racing = Racing.of("pobi,woni");
                    racing.runRound();
                    assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(0);
                    assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(1);
                    racing.runRound();
                    assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(1);
                    assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(2);
                    racing.runRound();
                    assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(2);
                    assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(3);
                },
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
