package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingSimulateTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자_1명_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 우승자_없는_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : ", "woni : ", "결승선을 통과한 자동차가 없습니다. \n우승자는 없습니다.");
            },
            STOP, STOP
        );
    }

    @Test
    void 이름_5자_초과() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("donghan,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("  ,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 콜론_포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi:,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 대시_포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("po-bi,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
