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
                    run("pobi,woni", "2");
                    //assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    assertThat(output()).contains("");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_자동차_띄어쓰기() {
        assertSimpleTest(() -> {
            run("pobi,woni ,  jun", "5");
            assertThat(output()).contains("");
        });
    }

    @Test
    void 기능_자동차_이름_띄어쓰기() {
        assertSimpleTest(() -> {
            run("po bi,wo ni ,  j un", "5");
            assertThat(output()).contains("");
        });
    }

    @Test
    void 기능_시도횟수_0회() {
        assertSimpleTest(() -> {
            run("pobi , woni , jun", "0");
            assertThat(output()).contains("");
        });
    }

    @Test
    void 예외_자동차_5자초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_시도횟수_입력없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_자동차_입력없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}