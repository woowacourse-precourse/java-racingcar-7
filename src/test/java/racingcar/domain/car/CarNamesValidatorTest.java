package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesValidatorTest {
    @Test
    void 유효한_이름_리스트는_예외없이_통과() {
        List<String> names = List.of("car1", "car2", "car3");
        assertDoesNotThrow(() -> CarNamesValidator.validate(names));
    }

    @Test
    void 빈_문자열_포함된_리스트는_예외_발생() {
        List<String> names = List.of("car1", "", "car3");
        assertThrows(IllegalArgumentException.class, () -> CarNamesValidator.validate(names));
    }

    @Test
    void 중복된_이름이_포함된_리스트는_예외_발생() {
        List<String> names = List.of("car1", "car1", "car3");
        assertThrows(IllegalArgumentException.class, () -> CarNamesValidator.validate(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "car123", "abcdefg"})
    void 이름의_길이가_유효하지_않으면_예외_발생(String invalidName) {
        List<String> names = List.of("car1", invalidName, "car3");
        assertThrows(IllegalArgumentException.class, () -> CarNamesValidator.validate(names));
    }
}
