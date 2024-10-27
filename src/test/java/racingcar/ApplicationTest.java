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
    void blankTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("alpha,,bravo", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trimTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" alpha  ,be ta", "3");
                    assertThat(output()).contains("alpha : --", "be ta : --", "최종 우승자 : alpha, be ta");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void duplicateNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("alpha,beta,alpha", "3"))
                        .isInstanceOf(Validate.DuplicateNameDetected.class)
        );
    }

    @Test
    void invalidRangeTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("alpha,beta", "-2"))
                        .isInstanceOf(Validate.CannotBeNegative.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
