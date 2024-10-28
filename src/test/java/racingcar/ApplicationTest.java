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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_2대_미만() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_중복() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi,povi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_플레이어_공백() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_플레이어_null() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(null, "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_콜론_미포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi.eddy", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_숫자아님() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi,eddy", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi,eddy", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_소수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("povi,eddy", "3.14"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
