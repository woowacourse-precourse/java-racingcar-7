package racingcar.mvc.validation.input;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("아무것도 입력하지 않았을 때")
    void test1(String input) {
        assertThatThrownBy(() -> CarNameValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하지 않았습니다."); // Change the message as appropriate
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,son,kim,,june", "kim,,jun"})
    @DisplayName("공백이 들어왔을 때")
    void test2(String input) {
        assertThatThrownBy(() -> CarNameValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하지 않았습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "kim"})
    @DisplayName("한 명만 입력했을 때")
    void test3(String input) {
        assertThatThrownBy(() -> CarNameValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 명만 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii,kim", "kim,sonnnn"})
    @DisplayName("이름 길이 초과")
    void test4(String input) {
        assertThatThrownBy(() -> CarNameValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}