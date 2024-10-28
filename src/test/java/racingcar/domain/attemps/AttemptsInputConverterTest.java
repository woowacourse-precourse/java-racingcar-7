package racingcar.domain.attemps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.attempts.AttemptsInputConverter;

public class AttemptsInputConverterTest {

    @Test
    void 유효한_정수_입력을_변환하는지_테스트() {
        String input = "5";
        int result = AttemptsInputConverter.convert(input);
        assertEquals(5, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 일_미만의_입력값은_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> AttemptsInputConverter.convert(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", " ", ""})
    void 정수가_아닌_입력값은_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> AttemptsInputConverter.convert(input));
    }
}
