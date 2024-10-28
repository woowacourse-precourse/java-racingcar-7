package racingcar.mvc.validation.input;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 아무것도_들어오지_않았을_때(String input) {
        assertThatThrownBy(() -> CarNameValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하지 않았습니다."); // Change the message as appropriate
    }
}