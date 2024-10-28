package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    void checkCarNamesError_유효한입력_배열반환() {
        String[] result = input.checkCarNamesError("car1,car2,car3");
        assertArrayEquals(new String[]{"car1", "car2", "car3"}, result);
    }

    @Test
    void checkCarNamesError_공백포함입력_트리밍된배열반환() {
        String[] result = input.checkCarNamesError(" car1 , car2 , car3 ");
        assertArrayEquals(new String[]{"car1", "car2", "car3"}, result);
    }

    @Test
    void checkCarNamesError_널입력_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> input.checkCarNamesError(null));
    }

    @Test
    void checkCarNamesError_길이가긴이름_예외발생() {
        assertThrows(IllegalArgumentException.class,
            () -> input.checkCarNamesError("car1,toolongname,car3"));
    }

    @Test
    void checkCarNamesError_빈이름_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> input.checkCarNamesError("car1,,car3"));
    }

    @Test
    void checkCarNamesError_단일빈이름_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> input.checkCarNamesError(""));
    }

    @Test
    void checkCarNamesError_콤마만있는입력_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> input.checkCarNamesError(",,"));
    }

    @Test
    void checkCarNamesError_모두공백인입력_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> input.checkCarNamesError("   "));
    }

    @Test
    void checkAttemptedNumberError_숫자가아닌값_입력시_예외발생(){
        assertThrows(IllegalArgumentException.class, ()->input.checkAttemptedNumberError("aadsf"));
    }

    @Test
    void checkAttemptedNumberError_숫자가음수일때_예외발생(){
        assertThrows(IllegalArgumentException.class,()-> input.checkAttemptedNumberError("-123"));
    }

}