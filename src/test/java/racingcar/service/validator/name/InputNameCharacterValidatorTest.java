package racingcar.service.validator.name;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputNameCharacterValidatorTest {
    private final static InputNameCharacterValidator inputNameCharacterValidator = new InputNameCharacterValidator();

    @ParameterizedTest
    @ValueSource(strings = {"ji ho", "ji\nho", "ji   ho"})
    @DisplayName("이름에 공백문자 포함 시 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenContainsSpaceCharacter(String inputName) {

        //when & then
        assertThrows(IllegalArgumentException.class, () -> inputNameCharacterValidator.validate(inputName));
    }
}