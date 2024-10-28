package racingcar.global.validationUtils;

import org.junit.jupiter.api.Test;
import racingcar.global.error.validation.InputValidation;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    void 중복_검사_테스트() {
        InputValidation.checkDuplicate("pobi"); // 첫 입력, 에러 없음
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkDuplicate("pobi"));
    }

    @Test
    void 특수문자_검사_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkSpecialCharacters("po@bi"));
        assertDoesNotThrow(() -> InputValidation.checkSpecialCharacters("pobi"));
    }

    @Test
    void 길이_검사_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkLength("abcdef"));
        assertDoesNotThrow(() -> InputValidation.checkLength("pobi"));
    }

    @Test
    void 최소_자동차_개수_검사_테스트() {
        String[] singleCar = {"pobi"};
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkOnce(singleCar));

        String[] multipleCars = {"pobi", "woni"};
        assertDoesNotThrow(() -> InputValidation.checkOnce(multipleCars));
    }

    @Test
    void 공백_검사_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkWhite("   "));
        assertDoesNotThrow(() -> InputValidation.checkWhite("pobi"));
    }

    @Test
    void 음수_검사_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.checkParseInt(-1));
        assertDoesNotThrow(() -> InputValidation.checkParseInt(3));
    }

}