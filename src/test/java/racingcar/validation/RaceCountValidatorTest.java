package racingcar.validation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RaceCountValidatorTest extends NsTest {

    @Test
    void 음수를_입력한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_실수를_입력한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "3.141592"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열을_입력한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "Noah"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
