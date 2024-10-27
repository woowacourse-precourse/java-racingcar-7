package racingcar.validator;

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

class InputValidatorTest {

    @DisplayName("자동차 이름이 5글자를 넘으면 예외를 발생시킨다")
    @Test
    void 자동차_이름_길이_5글자_초과_예외() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "ca22r2");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));

        //then
        assertEquals(OVER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("자동차 이름이 1글자 미만이면 예외를 발생시킨다")
    @Test
    void 자동차_이름_길이_1글자_미만_예외() {
        //given
        List<String> carNames = Arrays.asList("car1", "");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));

        //then
        assertEquals(UNDER_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("자동차 이름에 공백이 포함되어 있으면 예외를 발생시킨다")
    @Test
    void 자동차_이름_공백_포함_예외() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "cd cd");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));

        //then
        assertEquals(CONTAIN_BLANK_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("자동차 이름에 특수문자가 포함되어 있으면 예외를 발생시킨다")
    @Test
    void 자동차_이름_특수문자_포함_예외() {
        //given
        List<String> carNames = Arrays.asList("car", "car1", "c3@");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));

        //then
        assertEquals(CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("자동차 이름이 중복되면 예외를 발생시킨다")
    @Test
    void 자동차_이름_중복_예외() {
        //given
        List<String> carNames = Arrays.asList("car", "CaR", "c3@");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));

        //then
        assertEquals(NAME_DUPLICATE_ERROR_MESSAGE, exception.getMessage());
    }
}
