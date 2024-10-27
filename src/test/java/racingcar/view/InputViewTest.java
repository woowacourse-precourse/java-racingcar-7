package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 사용자_입력_기능_예외(String userInput) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateUserInputNotEmpty(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}