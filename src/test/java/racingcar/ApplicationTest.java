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
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d,e", "1");
                    assertThat(output()).contains("a : -", "b : ", "c : -", "d : ", "e : -", "최종 우승자 : a, c, e");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
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
                assertThatThrownBy(() -> runException("pobi,Yuza", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,e,f,g,h,i,j,k", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", "11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", "1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
