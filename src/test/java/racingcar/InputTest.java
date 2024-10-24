package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    private final Input input = new Input();

    @Test
    void 비어있는_이름_입력시_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkValidation(""));
    }

    @Test
    void null_일때_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkValidation(null));
    }

    @Test
    void 올바른_입력_테스트() {
        input.checkValidation("ValidName");
    }

    @Test
    void 다섯_글자_이하_입력_테스트() {
        assertDoesNotThrow(() -> input.checkNameLength("pobi"));
        assertDoesNotThrow(() -> input.checkNameLength("woni"));
        assertDoesNotThrow(() -> input.checkNameLength("jun"));
    }

    @Test
    void 다섯_글자_초과_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkNameLength("pooobi"));
        assertThrows(IllegalArgumentException.class, () -> input.checkNameLength("wooooni"));
    }

    @Test
    void 라운드_입력_숫자_아닌_경우_예외(){
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt("a2"));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(""));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(" "));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(null));
    }

    @Test
    void 라운드_입력_올바른_경우(){
        assertDoesNotThrow(() -> input.checkRoundInt("123"));
        assertDoesNotThrow(() -> input.checkRoundInt("1"));
        assertDoesNotThrow(() -> input.checkRoundInt("12"));
        assertDoesNotThrow(() -> input.checkRoundInt("11000000"));
    }

}
