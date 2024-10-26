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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("우승자가 여러명일 경우, 테스트")
    void end_to_end_test_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임을 시도하지 않을 경우, 예외가 발생한다.")
    void end_to_end_test_2() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임을 시도 횟수가 음수일 경우, 예외가 발생한다.")
    void end_to_end_test_3() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
