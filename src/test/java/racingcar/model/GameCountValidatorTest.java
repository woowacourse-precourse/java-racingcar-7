package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class GameCountValidatorTest extends NsTest {

    @Test
    @DisplayName("시도 횟수가 음수인 경우")
    void 시도_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,goat", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 소수인 경우")
    void 시도_횟수_소수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,goat", "1.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 int 범위를 벗어나는 경우")
    void 시도_횟수_int_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,goat", "2200000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수를 정상적으로 입력한 경우")
    void 시도_횟수_정상적() {
        assertThatCode(() -> run("hail,good,abc", "100"))
                .doesNotThrowAnyException();
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}