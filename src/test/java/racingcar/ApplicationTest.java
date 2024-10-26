package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("우승자가 한 명인 경우")
    void 전진_테스트_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("good,hail", "3");
                    assertThat(output()).contains("good : ", "hail : --", "최종 우승자 : hail");
                },
                STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD,
                STOP, STOP
        );
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우")
    void 전진_테스트_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("hail, ssin,po", "5");
                    assertThat(output()).contains("hail : ---", "ssin : --", "po : ---", "최종 우승자 : hail, po");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
