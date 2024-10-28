package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputRaceCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", " ", "\n", "01"})
    void 숫자_입력_예외_테스트(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputUtils.parseRaceCountInput(input);
        });
    }
}
