package racingcar.validator;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidatorTest {


    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값이 빈문자열이라면 예외가 발생한다.")
    void testCarNameIsEmpty() {
        //given
        String emptyInput = "";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateIsEmpty(emptyInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"tobi"})//given
    @DisplayName("입력값이 1~5자면 정상 통과")
    void testSuccessInputLength(String input) {
        //when & then
        assertDoesNotThrow(() -> inputValidator.validateCarNameLength(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"too_long_name"}) //given
    @DisplayName("입력값이 6자 이상이면 예외가 발생한다.")
    void testFailInputLength(String input) {
        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarNameLength(input));

        // Then
        assertEquals("자동차 이름은 6자를 초과할 수 없습니다.", thrown.getMessage());
    }


}
