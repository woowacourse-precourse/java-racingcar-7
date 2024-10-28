package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void validateCarName_withEmptyName_throwsException() {
        assertThatThrownBy(() -> Application.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_withLongName_throwsException() {
        assertThatThrownBy(() -> Application.validateCarName("toolongname"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void validateAttempts_withZero_throwsException() {
        assertThatThrownBy(() -> Application.validateAttempts(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void validateAttempts_withNegativeNumber_throwsException() {
        assertThatThrownBy(() -> Application.validateAttempts(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
