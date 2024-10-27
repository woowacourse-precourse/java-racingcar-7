package racingcar.service.validator.round;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputRoundRangeValidatorTest {
    private final InputRoundRangeValidator inputRoundRangeValidator = new InputRoundRangeValidator();

    @ParameterizedTest
    @ValueSource(strings = {"0", "2147483648"})
    @DisplayName("시도 횟수가 1보다 작거나 2,147,483,647보다 크면 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenRoundCountRangeIsInvalid(String invalidRoundCount) {

        //when & then
        assertThrows(IllegalArgumentException.class, () -> inputRoundRangeValidator.validate(invalidRoundCount));
    }
}