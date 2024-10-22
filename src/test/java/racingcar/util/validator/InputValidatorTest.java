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

        //then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input1));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input2));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input3));
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(input4));
    }
}