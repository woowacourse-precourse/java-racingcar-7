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
    void 기능_테스트_단일이동횟수() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_여러이동횟수() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "3");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_여러자동차이동() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "2");
                assertThat(output()).contains(
                    "pobi : --",
                    "woni : -",
                    "jun : -",
                    "최종 우승자 : pobi"
                );
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_무승부() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 예외_테스트_자동차이름길이() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_빈자동차이름() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수이동횟수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가아닌이동횟수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "hello"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
