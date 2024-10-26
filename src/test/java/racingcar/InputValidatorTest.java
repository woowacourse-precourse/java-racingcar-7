package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constants.ErrorMessages.CONTAIN_BLANK_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.OVER_LENGTH_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.UNDER_LENGTH_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

class InputValidatorTest {

    @DisplayName("이름의 길이가 5글자를 넘으면 예외처리")
    @Test
    void validateCarNames_over_length_error() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "ca22r2");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        //then
        assertEquals(OVER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름의 길이가 1글자 미만이면 예외처리")
    @Test
    void validateCarNames_under_length_error() {
        //given
        List<String> carNames = Arrays.asList("car1", "");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        //then
        assertEquals(UNDER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름에 공백이 들어가 있으면 예외처리")
    @Test
    void validateCarNames_contain_blank_error() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "cd cd");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        //then
        assertEquals(CONTAIN_BLANK_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("이름에 특수문자가 들어가 있으면 예외처리")
    @Test
    void validateCarNames_contain_special_character_error() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "c3@");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        //then
        assertEquals(CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE, exception.getMessage());
    }
}