package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputCarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,a", "A,a,B", "aaaaaa,abc,d", ",", "a,b,"})
    void 입력_예외_테스트(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputUtils.parseCarNameInput(input);
        });
    }
}
