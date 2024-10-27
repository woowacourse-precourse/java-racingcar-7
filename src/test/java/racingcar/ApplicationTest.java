package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ExceptionMessage.ERROR_CAR_NAME_EMPTY;
import static racingcar.ExceptionMessage.ERROR_CAR_NAME_NOT_EXIST;
import static racingcar.ExceptionMessage.ERROR_TRY_COUNT_NOT_NATURAL_NUMBER;

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
    void 기능_테스트_공동우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
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
    void 예외_테스트_다중쉼표() {
        assertThatThrownBy(() -> runException("pobi,,java", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_CAR_NAME_EMPTY);
    }

    @Test
    void 예외_테스트_시도횟수() {
        assertThatThrownBy(() -> runException("pobi,java", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_TRY_COUNT_NOT_NATURAL_NUMBER);
    }

    @Test
    void 예외_테스트_빈문자열() {
        assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_CAR_NAME_NOT_EXIST);
    }

    @Test
    void 예외_테스트_쉼표만() {
        assertThatThrownBy(() -> runException(",,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_CAR_NAME_NOT_EXIST);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
