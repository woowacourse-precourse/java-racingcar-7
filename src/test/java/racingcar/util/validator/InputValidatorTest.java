package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 자동차_이름_검증_테스트() {
        //given
        String input1 = "포비,Alex,james";
        String input2 = "포비,알lexs,제임s";

        //then
        assertDoesNotThrow(() -> InputValidator.validateCarNames(input1));
        assertDoesNotThrow(() -> InputValidator.validateCarNames(input2));
    }

    @Test
    void 자동차_이름_검증_예외_테스트() {
        //given
        String input1 = "LongNameMan,short";
        String input2 = "john:rock";
        String input3 = "";
        String input4 = "철수,철수,영희";
        String input5 = null;

        //then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input1));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input2));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input3));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input4));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input5));
    }

    @Test
    void 시행횟수_검증_테스트() {
        //given
        String two = "2";
        String fifteen = "15";

        //then
        assertDoesNotThrow(() -> InputValidator.validateNumberOfTrial(two));
        assertDoesNotThrow(() -> InputValidator.validateNumberOfTrial(fifteen));
    }

    @Test
    void 시행횟수_검증_예외_테스트() {
        //given
        String notNum = "three";
        String notPositive = "-2";
        String tooBigNumber = "99999999999999999";
        String nullValue = null;

        //then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateNumberOfTrial(notNum));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateNumberOfTrial(notPositive));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateNumberOfTrial(tooBigNumber));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateNumberOfTrial(nullValue));
    }
}