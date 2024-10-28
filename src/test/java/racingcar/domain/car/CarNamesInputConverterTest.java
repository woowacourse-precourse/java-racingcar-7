package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesInputConverterTest {
    @Test
    void 올바른_입력을_리스트로_변환하는지_테스트() {
        String input = "car1,car2,car3";
        List<String> result = CarNamesInputConverter.convert(input);

        assertEquals(List.of("car1", "car2", "car3"), result);
    }

    @Test
    void 공백과_함께_입력된_이름을_리스트로_변환하는지_테스트() {
        String input = "car1 , car2 ,car3 ";
        List<String> result = CarNamesInputConverter.convert(input);

        assertEquals(List.of("car1", "car2", "car3"), result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 입력이_빈_문자열일경우_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> CarNamesInputConverter.convert(input));
    }

    @Test
    void 입력이_null_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> CarNamesInputConverter.convert(null));
    }
}
