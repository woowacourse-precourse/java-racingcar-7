package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 자동차_이름_5자_이상() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName("TooLongName");
        });
    }

    @Test
    void 자동차_이름_5자_이하() {
        assertDoesNotThrow(() -> Validator.validateCarName("CarA"));
        assertDoesNotThrow(() -> Validator.validateCarName("CarB"));
    }

    @Test
    void 자동차_이름_공백_포함() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName(" ");
        });
    }

    @Test
    void 자동차_이름_공백_포함2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName("pobi, woni");
        });
    }

    @Test
    void 자동차_이름_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName("");
        });
    }

    @Test
    void 시도횟수_숫자_아님() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateTryNumber("CarA");
        });
    }

    @Test
    void 시도횟수_음수_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateTryNumber("-3");
        });
    }

    @Test
    void 시도횟수_음수_0() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateTryNumber("0");
        });
    }

    @Test
    void 시도횟수_숫자() {
        assertDoesNotThrow(() -> Validator.validateTryNumber("10"));
    }
}
