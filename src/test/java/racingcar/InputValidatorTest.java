package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi;woni", "pobi.woni", "pobi/woni"})
    void 이름_구분자가_쉼표가_아닌경우_예외발생(String nameInput) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                InputValidator.validateNames(nameInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,", ",woni,jun", "pobi,,jun", "pobi,woni,", "    , woni, jun"})
    void 자동차_이름이_공백인경우_예외발생(String nameInput) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                InputValidator.validateNames(nameInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "spaceeeeee"})
    void 자동차_이름이_5자_초과인경우_예외발생(String nameInput) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                InputValidator.validateNames(nameInput));
    }
}
