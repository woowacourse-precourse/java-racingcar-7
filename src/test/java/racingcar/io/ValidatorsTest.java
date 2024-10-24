package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

}