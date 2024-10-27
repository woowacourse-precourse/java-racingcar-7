package racingcar.service.validator.round;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputRoundFormatValidatorTest {
    private final InputRoundFormatValidator inputRoundFormatValidator = new InputRoundFormatValidator();

    @ParameterizedTest
    @ValueSource(strings = {"a", "\n", "", "*"})
    @DisplayName("시도 횟수가 Integer가 아니면 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenRoundCountIsInvalid(String invalidRoundCount) {

        //when & then
        assertThrows(IllegalArgumentException.class, () -> inputRoundFormatValidator.validate(invalidRoundCount));
    }
}