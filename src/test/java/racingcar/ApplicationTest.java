package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    // 다양한 케이스 정상 동작 테스트해보기
    @Test
    void 한명이_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 두명이_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sall", "5");
                    assertThat(output()).contains("pobi : --", "woni : ", "sall : --", "최종 우승자 : pobi, sall");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 여러명이_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sall,a,b,c,d,e", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "sall : -", "a : -", "b : -", "c : -",
                            "d : -", "e : -", "최종 우승자 : pobi, woni, sall, a, b, c, d, e");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
