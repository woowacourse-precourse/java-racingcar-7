package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("공동 우승 기능 테스트")
    @Test
    void gameStart_multipleWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,kim,ori-3", "3");
                    assertThat(output()).contains("pobi : --", "kim : -", "ori-3 : --", "최종 우승자 : pobi, ori-3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("여러 예외 상황 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,ori-345!2", "pobi;kim;334!3", "!3", "kim,cn ki,lee!4",
            "kim,pobi,jj3!b", "kim,pobi,jun!01",}, delimiter = '!')
    void exceptionTest_throwsException(String carName, String trialCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, trialCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
