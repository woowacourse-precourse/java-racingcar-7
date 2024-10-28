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

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,이름다섯자", "3");
                    assertThat(output()).contains("pobi : --", "이름다섯자 : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,밥 딜런", "3");
                    assertThat(output()).contains("pobi : --", "밥 딜런 : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );

    }

    @Test
    void 동명이인_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi,woni", "3");
                    assertThat(output()).contains("pobi(2) : --", "woni : ", "최종 우승자 : pobi(2)");
                },
                STOP, STOP, STOP, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 아무도_출발_못한_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni, jun");
                },
                STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP
        );

    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,이름이여섯자", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "A"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
