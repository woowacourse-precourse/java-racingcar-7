package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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
    @DisplayName("구분자(,) 예외 테스트")
    void commaExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 입력 최소 제한 테스트")
    void playerMinLimitExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 입력 최대 제한 테스트")
    void playerMaxLimitExceptionTest() {
        int NAME_LIMIT = 100;
        int count = 0;

        StringBuilder inputBuilder = new StringBuilder();

        genLoop:
        for (int x = 'a'; x <= 'z'; x++) {
            for (int y = x; y <= 'z'; y++) {
                if (count == NAME_LIMIT + 1) {
                    break genLoop;
                }
                inputBuilder.append((char) x).append((char) y).append(",");
                count++;
            }
        }

        String testInput = inputBuilder.toString();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testInput, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정수 입력 범위 초과 테스트")
    void overIntegerParseErrorTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", Integer.MAX_VALUE + "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정수 입력에 대한 문자열 입력 제한 테스트")
    void stringParseErrorTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "hello world"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("최대 시뮬레이션 횟수 제한 테스트")
    void simulationMaxLimitTest() {
        int TRIAL_LIMIT = 100;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", String.valueOf(TRIAL_LIMIT + 1)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("최소 시뮬레이션 횟수 제한 테스트")
    void simulationMinLimitTest() {
        int TRIAL_LIMIT = 0;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", String.valueOf(TRIAL_LIMIT)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

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
}
