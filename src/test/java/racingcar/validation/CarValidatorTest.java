package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"i am", "i    ", "    i"})
    void 이름_중간에_띄어쓰기_허용(String testName) {
        Validator<String> validator = new CarValidator();

        assertThatCode(() -> validator.validate(testName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"polabi", "p    i", "pobiholymoly"})
    void 이름이_5자리_초과면_예외(String testName) {
        Validator<String> validator = new CarValidator();

        assertThatThrownBy(() -> validator.validate(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자리 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    void 이름이_공백이거나_빈칸이면_예외(String testName) {
        Validator<String> validator = new CarValidator();

        assertThatThrownBy(() -> validator.validate(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
    }
}
