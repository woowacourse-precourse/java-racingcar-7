package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constants.ErrorMessages.CONTAIN_BLANK_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.OVER_LENGTH_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.UNDER_LENGTH_ERROR_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

class InputValidatorTest {

    @DisplayName("이름의 길이가 5글자를 넘으면 예외처리")
    @Test
    void validateCarName_over_length_error() {
        //given
        String carName = "carName";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
        //then
        assertEquals(OVER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름의 길이가 1글자 미만이면 예외처리")
    @Test
    void validateCarName_under_length_error() {
        //given
        String carName = "";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
        //then
        assertEquals(UNDER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름에 공백이 들어가 있으면 예외처리")
    @Test
    void validateCarName_contain_blank_error() {
        //given
        String carName = "HE LO";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
        //then
        assertEquals(CONTAIN_BLANK_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름에 특수문자가 들어가 있으면 예외처리")
    @Test
    void validateCarName_contain_special_character_error() {
        //given
        String carName = "hi@";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
        //then
        assertEquals(CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE, exception.getMessage());
    }
}