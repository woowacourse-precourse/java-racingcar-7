package racingcar.Input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.Input.InputString.inputString;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputTest extends NsTest {

    @Test
    public void 올바른_입력_값이다() {
        // given
        String input = "pobi,woni,jun";

        // when
        String result = inputString(input);

        // then
        assertEquals("문자열이 정규식에 맞습니다.", result);            // junit assertion
    }

    @Test
    public void 숫자를_포함한_자동차_입력은_가능하다() {
        // given
        String input = "pobi123,woni1,jun6";

        // when
        String result = inputString(input);

        // then
        assertEquals("문자열이 정규식에 맞습니다.", result);            // junit assertion
    }

    @Test
    public void 특수문자를_포함한_자동차_입력은_불가능하다() {
        // given
        String input = "pobi!@#,woni!!!,jun^0^";

        // when
        String result = inputString(input);

        // then
        assertEquals("문자열이 정규식에 맞지 않습니다.", result);            // junit assertion
    }

    @Test
    public void 쉼표로_시작하거나_끝나는_자동차_입력은_불가능하다() {
        // given
        String input = "pobi,woni,";

        // when
        String result = inputString(input);

        // then
        assertEquals("문자열이 정규식에 맞지 않습니다.", result);            // junit assertion
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
