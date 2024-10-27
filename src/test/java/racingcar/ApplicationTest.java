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
    void 공동_우승자_없는_경우 () {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3 ");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
                );
    }

    @Test
    void 공동_우승자_있는_경우 () {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 입력값_공백인_경우 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("         ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 입력값_null_경우 () {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException(null, "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    void 자동차_이름_공백인_경우1 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백인_경우2 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 자동차_이름_공백인_경우3 () {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    void 자동차_이름_5글자_초과한_경우 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,woowacourse", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_공백인_경우1 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_공백인_경우2 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_NULL인_경우 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 이동_횟수_공백인_경우3 () {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,woni", ""))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    void 이동_횟수_음수인_경우 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_0인_경우 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_숫자_아닌_경우 () {
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
