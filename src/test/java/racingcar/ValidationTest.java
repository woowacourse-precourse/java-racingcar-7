package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {
    @Test
    void isValidKeys() {
        assertTrue(InputValidation.isValidKeys(List.of("woni,jigi".split(",")))); // 정상 입력
        assertTrue(InputValidation.isValidKeys(List.of("woni7,JIGI2".split(",")))); // 정상 입력

        assertFalse(InputValidation.isValidKeys(List.of("".split(",")))); // 빈 값 입력
        assertFalse(InputValidation.isValidKeys(List.of(",,,,,".split(",")))); // ,(쉼표)만 입력
        assertFalse(InputValidation.isValidKeys(List.of("pobi,javaji".split(",")))); // 5글자 초과 입력
        assertFalse(InputValidation.isValidKeys(List.of("  pobi,jigi  ".split(",")))); // 공백 입력
        assertFalse(InputValidation.isValidKeys(List.of("p$bi,j!gi".split(",")))); // 특수문자 입력
    }

    @Test
    void isValidNumber() {
        assertTrue(InputValidation.isValidNumber("5")); // 정상 입력

        assertFalse(InputValidation.isValidNumber("")); // 빈 값 입력
        assertFalse(InputValidation.isValidNumber("-10")); // 음수 입력
        assertFalse(InputValidation.isValidNumber("0")); // 0 입력
        assertFalse(InputValidation.isValidNumber("j2")); // 문자 입력
        assertFalse(InputValidation.isValidNumber("!2")); // 특수문자 입력
    }
}