package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 목록 생성 예외 테스트")
    @EmptySource
    @ValueSource(strings = {"winG,winG", "winG,ph,winG"})
    void createInValidCars(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @ParameterizedTest
    @DisplayName("유효한 자동차 목록 생성 테스트")
    @ValueSource(strings = {"phobi", "woni,bmwM3"})
    void createValidName(String input) {
        Cars cars = new Cars(input);
        String[] expected = input.split(",");

        assertEquals(expected.length, cars.getCars().size());
    }
}
