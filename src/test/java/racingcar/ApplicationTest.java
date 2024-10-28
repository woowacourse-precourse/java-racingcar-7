package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 기능_테스트_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d", "2");
                    assertThat(output()).contains("a : --", "b : --", "c : ", "d : ", "최종 우승자 : a, b");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 기능_테스트_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d", "1");
                    assertThat(output()).contains("a : ", "b : ", "c : ", "d : ", "최종 우승자 : a, b, c, d");
                },
                STOP, STOP, STOP, STOP

        );
    }

    @Test
    void 기능_테스트_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d", "2");
                    assertThat(output()).contains("a : -", "b : ", "c : ", "d : ", "최종 우승자 : a");
                },
                MOVING_FORWARD, STOP, STOP, STOP, STOP, STOP, STOP, STOP

        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
