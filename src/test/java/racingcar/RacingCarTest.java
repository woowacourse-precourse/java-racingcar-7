package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 시도횟수_0_성공() {
        run("pobi", "0");
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    void 시도횟수_5_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output()).contains("pobi : -", "pobi : -", "pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 단독우승_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : ", "jun : --",
                            "pobi : ---", "woni : -", "jun : --",
                            "pobi : ----", "woni : --", "jun : ---",
                            "pobi : -----", "woni : ---", "jun : ----",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공동우승_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -", "jun : ---",
                            "pobi : ---", "woni : --", "jun : ---",
                            "pobi : ----", "woni : ---", "jun : ----",
                            "pobi : -----", "woni : ----", "jun : -----",
                            "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 빈_이름_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("  ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_사이_공백_이름_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_사이_빈_이름_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_숫자_아님_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ", "A"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_5자_초과_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobibi ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표가_아닌_구분자로_길이_초과_실패() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi&jun ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}