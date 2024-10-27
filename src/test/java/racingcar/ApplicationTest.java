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
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("jae,hwi,song", "3");
                    assertThat(output()).contains("jae : -", "hwi : --", "song : ---", "최종 우승자 : song");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("yang,chong,kim", "5");
                    assertThat(output()).contains("yang : ----", "chong : ----", "kim : --", "최종 우승자 : yang, chong");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("Giggs,Kane,Son", "3");
                    assertThat(output()).contains("Giggs : --", "Kane : --", "Son : --", "최종 우승자 : Giggs, Kane, Son");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
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
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("song,yang,choi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kevin,princ,sawn", "q"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("nels,kawt,mac", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("efe,fyke", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
