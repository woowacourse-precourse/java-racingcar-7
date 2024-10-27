package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 시도_횟수_검사() {
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNum("0"), "에라");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNum("-1"), "에러");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNum("a"), "에러");
    }

    @Test
    void 자동차_이름_검사() {
        String[] emptyerror = {"pobi", ""};
        String[] lengtherror = {"pobi", "wonnnni"};

        assertThrows(IllegalArgumentException.class, () -> Validation.validateNames(emptyerror), "에러");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNames(lengtherror), "에러");
    }
}