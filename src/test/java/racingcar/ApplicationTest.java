package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("최종 우승자가 여려명인 경우")
    @Test
    void manyWinnersTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, java", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "java : -", "최종 우승자 : pobi, java");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름 중 빈 문자열이 포함된 경우")
    @Test
    void emptyCarNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수가 음수인 경우")
    @Test
    void negativeRunLimitTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, b", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름이 중복된 경우")
    @Test
    void duplicateCarNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
