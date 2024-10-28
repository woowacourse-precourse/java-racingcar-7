package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("주어진 입력으로 경주가 정상적으로 진행된다.")
        void testRaceProgressAndWinner() {
            // given & when & then
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("5자를 초과한 이름이 입력으로 주어지면 IllegalArgumentException을 발생시킨다")
        void testNameExceedsMaxLengthInput() {
            // given
            String name = "javaji";

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi," + name, "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("빈 문자열이 자동차 이름으로 주어지면 IllegalArgumentException을 발생시킨다")
        void testEmptyCarNameInput() {
            // given & when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("시도 횟수가 음수이면 IllegalArgumentException을 발생시킨다")
        void testNegativeNumberOfAttemptsInput() {
            // given & when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("시도 횟수가 숫자가 아니면 IllegalArgumentException을 발생시킨다")
        void testNonNumericNumberOfAttemptsInput() {
            // given & when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "test"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
