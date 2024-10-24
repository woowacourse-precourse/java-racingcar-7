package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ErrorMessage.WRONG_CAR_NAME;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class FeatureTest {
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

        @ParameterizedTest
        @CsvSource(value = {"pobi,woni:1:pobi, woni", "a,b:1:a, b"}, delimiter = ':')
        void 공동_우승자(String names, String tryCnt, String winner) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(names, tryCnt);
                        assertThat(output()).contains("최종 우승자 : " + winner);
                    },
                    MOVING_FORWARD, MOVING_FORWARD
            );
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void 예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(WRONG_CAR_NAME.getMessage())
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
