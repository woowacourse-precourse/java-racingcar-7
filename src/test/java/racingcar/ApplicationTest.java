package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    void 복수_라운드() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains(
                            "pobi : -",
                            "pobi : --",
                            "woni : ",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 복수_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jacob", "1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "jacob : ",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
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
    void 빈문자열_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void zero_라운드_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void negative_라운드_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void non_number_라운드_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void invalid_구분자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_1000_초과() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "1001"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시작선_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jacob", "1");
                    assertThat(output()).contains(
                            "pobi : ",
                            "woni : ",
                            "jacob : ",
                            "최종 우승자 : pobi, woni, jacob");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 시작라운드_zero() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jacob", "3");
                    assertThat(output()).contains(
                            "pobi : ",
                            "woni : ",
                            "jacob : ",

                            "pobi : -",
                            "woni : ",
                            "jacob : -",

                            "pobi : --",
                            "woni : ",
                            "jacob : --",

                            "최종 우승자 : pobi, jacob");
                },
                STOP, STOP, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void number_move_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains(
                            "pobi : ",
                            "woni : -",

                            "pobi : ",
                            "woni : --",

                            "pobi : ",
                            "woni : ---",

                            "pobi : ",
                            "woni : ----",

                            "pobi : ",
                            "woni : -----",

                            "최종 우승자 : woni");
                },
                0, 4,
                1, 5,
                2, 6,
                3, 7,
                3, 8,
                3, 9
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
