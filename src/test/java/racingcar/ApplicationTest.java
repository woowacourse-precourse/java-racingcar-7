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

    @DisplayName("기능 테스트2")
    @Test
    void function_test_2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "5");
                assertThat(output().contains("최종 우승자 : pobi, jun"));
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("자동차 이름에 앞뒤로 공백이 포함된 경우, 정상적으로 이름을 처리하는지 테스트")
    @Test
    void should_Trim_When_CarNameIncludesSpaces() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,   woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("시도 횟수 0 이하인 경우 예외 발생 테스트")
    @Test
    void should_ThrowException_When_NonPositiveTurns() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
