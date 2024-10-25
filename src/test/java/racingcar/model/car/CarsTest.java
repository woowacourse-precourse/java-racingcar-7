package racingcar.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("유효한 자동차 목록 생성 테스트")
    @ValueSource(strings = {"phobi", "woni,bmwM3"})
    void createValidName(String input) {
        Cars cars = new Cars(input);

        String[] expected = input.split(",");

        assertThat(cars.getCars().size()).isEqualTo(expected.length);
    }
}