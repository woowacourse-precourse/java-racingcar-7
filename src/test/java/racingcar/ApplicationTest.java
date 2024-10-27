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
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("leo,star", "2");
                assertThat(output()).contains("최종 우승자 : leo, star");
            },
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_테스트2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("leo,star,rin", "4");
                assertThat(output()).contains("최종 우승자 : leo, star");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 계속_정지만_나왔을때_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("leo,star,rin", "3");
                assertThat(output()).contains("최종 우승자 : leo, star, rin");
            },
            STOP, STOP, STOP,
            STOP, STOP, STOP,
            STOP, STOP, STOP
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
    void 콤마_사이_공백_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("leo, ,star", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_숫자_아닌_경우_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("leo, ,star", "n"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_0_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("leo, ,star", "0"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
