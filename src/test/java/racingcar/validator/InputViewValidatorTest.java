package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static racingcar.validator.ErrorMessage.EMPTY_OR_BLANK_INPUT_ERROR;
import static racingcar.validator.ErrorMessage.NON_NUMERIC_INPUT_ERROR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewValidatorTest {
    private InputViewValidator inputViewValidator;

    @BeforeEach
    void setUp() {
        inputViewValidator = new InputViewValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 문자열이_널이거나_공백이면_에러가_발생한다(String userInput) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class,
                () -> {
                    inputViewValidator.validateNotNullAndBlank(userInput);
                }
        );
        assertEquals(EMPTY_OR_BLANK_INPUT_ERROR.getMessage(), e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "3D"})
    void 문자열이_숫자가_아니면_에러가_발생한다(String userInput) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class,
                () -> {
                    inputViewValidator.validateNumeric(userInput);
                }
        );
        assertEquals(NON_NUMERIC_INPUT_ERROR.getMessage(), e.getMessage());
    }
}