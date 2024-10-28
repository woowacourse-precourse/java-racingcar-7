package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ExceptionMessages;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class PossibleTest {
        @Test
        void 시도횟수_1일경우_한명의_우승자() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 시도횟수_2이며_두명의_우승자() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "2");
                        assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
            );
        }

        @Test
        void 시도횟수_2이며_한명의_우승자() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "2");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP, STOP, STOP
            );
        }
    }

    @Nested
    class ImpossibleTest {
        @Test
        void 참가자_2명_미만일_경우_예외발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi", "5"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ExceptionMessages.MINIMUM_TWO_CARS_REQUIRED)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = { "0", "-1"})
        void 시도횟수_1_미만일_경우_예외발생(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,won", input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ExceptionMessages.NON_NATURAL_NUMBER)
            );
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
