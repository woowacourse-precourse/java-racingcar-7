package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,woni;jun",
            "pobi,woni,jeongmin",
            "pobi,woni,pobi",
            "",
            "\\n,\\n",
            ",",
            "pobi,",
            "1234567890"
    })
    void 자동차_이름_잘못된_입력_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validateDelimitedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "친구0,친구1,친구2",
            "친구0",
            "pobi",
            " ,  ,   ",
            "!@#@,#$@"
    })
    void 자동차_이름_올바른_입력_테스트(String input) {
        assertThatCode(() -> inputValidator.validateDelimitedCarNames(input)).doesNotThrowAnyException();
    }
}
