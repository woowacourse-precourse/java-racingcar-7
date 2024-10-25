package racingcar.Input;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.service.InputService.isCorrectInput;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CorrectInputTest extends NsTest {

    @Test
    public void 올바른_입력_값이다() {
        // given
        String input = "pobi,woni,jun";

        // when
        boolean result = isCorrectInput(input);

        // then
        assertTrue(result);
    }

    @Test
    public void 숫자를_포함한_자동차_입력은_가능하다() {
        // given
        String input = "pobi123,woni1,jun6";

        // when
        boolean result = isCorrectInput(input);

        // then
        assertTrue(result);
    }

    @Test
    public void 특수문자를_포함한_자동차_입력은_불가능하다() {
        // given
        String input = "pobi!@#,woni!!!,jun^0^";

        // when
        boolean result = isCorrectInput(input);

        // then
        assertFalse(result);
    }

    @Test
    public void 쉼표로_시작하거나_끝나는_자동차_입력은_불가능하다() {
        // given
        String input = "pobi,woni,";

        // when
        boolean result = isCorrectInput(input);

        // then
        assertFalse(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
