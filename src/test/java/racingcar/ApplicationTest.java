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
                run("pobi,woni,kim", "3");
                assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "kim : -",
                            "pobi : -",
                            "woni : -",
                            "kim : --",
                            "pobi : --",
                            "woni : -",
                            "kim : ---",
                            "최종 우승자 : kim"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,  // 1회차 (pobi 이동, woni 멈춤, kim 이동)
                STOP, MOVING_FORWARD, MOVING_FORWARD,  // 2회차 (pobi 멈춤, woni 이동, kim 이동)
                MOVING_FORWARD, STOP, MOVING_FORWARD   // 3회차 (pobi 이동, woni 멈춤, kim 이동)
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
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb,cc,dd,ee,ff", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
