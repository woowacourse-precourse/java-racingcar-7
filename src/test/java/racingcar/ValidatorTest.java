package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private static Validator validator = new Validator();
    @Test
    public void 공백_이름이_존재() throws Exception{
        assertThrows(IllegalArgumentException.class , () -> validator.checkIfNameInputIsLegal("p,,j".split(",")));
    }

    @Test
    public void 공백_입력() throws Exception{
        assertThrows(IllegalArgumentException.class , () -> validator.checkIfNameInputIsLegal("".split(",")));
    }

    @Test
    public void 너무_긴_이름이_존재() throws Exception{
        assertThrows(IllegalArgumentException.class , () -> validator.checkIfNameInputIsLegal("a,abcdesesd".split(",")));
    }

    @Test
    public void 쉼표만_존재() throws Exception{
        assertThrows(IllegalArgumentException.class , () -> validator.checkIfNameInputIsLegal(",,,,".split(",")));
    }

    @Test
    public void 한_사람만_존재() throws Exception{
        assertThat(validator.checkIfNameInputIsLegal("aois".split(","))).isTrue();
    }
}
