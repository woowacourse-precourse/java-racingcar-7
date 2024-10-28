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
    @DisplayName("기능 테스트")
    void applicationTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("예외 테스트")
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력한 시도 횟수가 0 일 때")
    void tryNumberIsZeroExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("길이가 0인 자동차 이름을 입력할 때")
    void colonIsNotOneExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,,java", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 글자를 입력했을 때")
    void tryNumIsNotNumberExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 아무것도 입력하지 않았을 때")
    void tryNumIsNothingExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 때")
    void duplicatedCarNameExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,pobi", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
