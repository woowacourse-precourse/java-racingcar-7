package racingcar.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    Validators validators = new Validators();

    @Test
    void 자동차_이름_입력_테스트_공백1() {
        String input = ",a,b,c,";
        assertThrows(IllegalArgumentException.class, () -> validators.validateString(input));
    }

    @Test
    void 자동차_이름_입력_테스트_공백2() {
        String input = "a,b,,c";
        assertThrows(IllegalArgumentException.class, () -> validators.validateString(input));
    }

    @Test
    void 자동차_이름_입력_테스트_이름글자수() {
        String input = "aaaaaa,bbbbbbb,cd";
        assertThrows(IllegalArgumentException.class, () -> validators.validateString(input));
    }

    @Test
    void 자동차_이름_입력_테스트_중복이름() {
        String input = "cd,cd,cd";
        assertThrows(IllegalArgumentException.class, () -> validators.validateString(input));
    }

    @Test
    void 자동차_이름_입력_테스트_정상() {
        String input = "a,b,c";

        String[] output = validators.validateString(input);

        assertArrayEquals(new String[]{"a", "b", "c"}, output);
    }


    @Test
    void 시도할_횟수_입력_테스트1() {
        String input = "3.4";
        assertThrows(IllegalArgumentException.class, () -> validators.validateInteger(input));
    }

    @Test
    void 시도할_횟수_입력_테스트2() {
        String input = "qwer";
        assertThrows(IllegalArgumentException.class, () -> validators.validateInteger(input));
    }

    @Test
    void 시도할_횟수_입력_테스트_정상() {
        String input = "9";

        int num = validators.validateInteger(input);

        assertThat(num).isEqualTo(9);
    }
}