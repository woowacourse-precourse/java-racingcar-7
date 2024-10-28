package racingcar.mvc.validation.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 아무것도_들어오지_않았을_때(String input) {
        assertThatThrownBy(() -> AttemptNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하지 않았습니다."); // Change the message as appropriate
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁ", "a", "*"})
    void 문자가_들어왔을_때(String input) {
        assertThatThrownBy(() -> AttemptNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 숫자가 아닙니다."); // Change the message as appropriate
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void 숫자_0이_들어왔을_때(String input) {
        assertThatThrownBy(() -> AttemptNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 양의 정수가 아닙니다."); // Change the message as appropriate
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "-10000"})
    void 음수가_들어왔을_때(String input) {
        assertThatThrownBy(() -> AttemptNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 양의 정수가 아닙니다."); // Change the message as appropriate
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.1", "-1.1", "10.0"})
    void 소수가_들어왔을_때(String input) {
        assertThatThrownBy(() -> AttemptNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 숫자가 아닙니다."); // Change the message as appropriate
    }
}