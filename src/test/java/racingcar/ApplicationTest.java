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

//    @Test
//    void 기능_테스트() {
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("pobi,woni", "1");
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//            },
//            MOVING_FORWARD, STOP
//        );
//    }

    @Test
    void move_임시_테스트1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "5");
                assertThat(output()).contains("5 0");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void move_임시_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "5");
                    assertThat(output()).contains("5 5 5");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test // 5글자 이상
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_자동차입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_자동차이름_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_자동차이름_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가아닌_시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void overflow_시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "2200000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
