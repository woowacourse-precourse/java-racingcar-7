package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

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
    @DisplayName("자동차 이름에 빈 문자열을 입력시 예외가 발생한다.")
    void testInputEmptyStringNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.INPUT_EMPTY_STRING.getMessage())
        );
    }

    @Test
    @DisplayName("횟수에 숫자가 아닌 값을 입력시 예외가 발생한다.")
    void testInputNonDigitTrialCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test2", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.INPUT_NON_DIGIT_CHARACTER.getMessage())
        );
    }

    @Test
    @DisplayName("횟수에 정수 범위를 초과하는 값을 입력시 예외가 발생한다.")
    void testInputOverFlowTrialCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test2", "99999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.INPUT_INVALID_INTEGER_RANGE.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
