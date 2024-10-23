package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("자동차 이름을 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmpty(String input) {
        //given //when //then
        assertThatThrownBy(() -> inputValidation.validateNullOrEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}