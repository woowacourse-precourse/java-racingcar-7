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

}
