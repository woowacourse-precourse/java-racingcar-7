package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 정상() {
        String input = "pobi,woni,jun";
        assertTrue(Validator.validateCarNames(input));
    }

    @Test
    void 공백포함_글자제한_넘어가는_자동차() {
        String input = "pobi   ,test,jun";
        assertTrue(Validator.validateCarNames(input));
    }

    @Test
    void 널() {
        String input = null;
        assertFalse(Validator.validateCarNames(input));
    }

    @Test
    void 전체_Blank() {
        String input = " ";
        assertFalse(Validator.validateCarNames(input));
    }

    @Test
    void 중간_Blank() {
        String input = "pobi,  ,jun";
        assertFalse(Validator.validateCarNames(input));
    }

    @Test
    void 글자제한_넘어가는_자동차이름() {
        String input = "pobi,test5123,jun";
        assertFalse(Validator.validateCarNames(input));
    }
}