package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sam", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "sam : -",
                            "pobi : -", "woni : ", "sam : - -",
                            "pobi : -", "woni : ", "sam : - - -",
                            "최종 우승자 : sam");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트3_다수의우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sam", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "sam : -",
                            "pobi : --", "woni : ", "sam : --",
                            "pobi : ---", "woni : ", "sam : ---",
                            "최종 우승자 : pobi, sam");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2_이름공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3_이동횟수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
