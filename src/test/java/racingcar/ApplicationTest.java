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
    private static final int UNDER = -1;
    private static final int OVER = 10;

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
    void 우승자가_두_명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "pobi : ---", "woni : --", "jun : ---",
                            "pobi : ----", "woni : ---", "jun : ----",
                            "pobi : -----", "woni : ----", "jun : -----",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 모두_우승자인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "jun : -",
                            "pobi : --", "woni : --", "jun : --",
                            "pobi : ---", "woni : ---", "jun : ---",
                            "최종 우승자 : pobi, woni, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 참가자가_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 무작위_값_초과_예외처리() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("pobi,woni", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                ,
                STOP, OVER
        );
    }

    @Test
    void 무작위_값_미만_예외처리() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("pobi, woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                ,
                MOVING_FORWARD, UNDER
        );
    }

    @Test
    void 잘못된_시도_횟수_0_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_시도_횟수_음수_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_시도_횟수_문자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1abc2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_사이_공백_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po bi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_사이_공백_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
