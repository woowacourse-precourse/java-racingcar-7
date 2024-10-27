package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.CarFactory;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "pobi,crong", "pobi"})
    @DisplayName("Creates cars with valid names")
    void createsCarsWithValidNames(String names) {
        List<Car> cars = CarFactory.createCars(names, 4, 5);
        Assertions.assertThat(cars).hasSize(names.split(",").length);
    }

    @Test
    @DisplayName("Throws exception for name exceeding limit length")
    void throwsExceptionForNameExceedingLimitLength() {
        String names = "pobi,crong,honuxxxxx";
        assertThatThrownBy(() -> CarFactory.createCars(names, 4, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("Throws exception for invalid name format")
    void throwsExceptionForInvalidNameFormat() {
        String names = "pobi;crong;honux";
        assertThatThrownBy(() -> CarFactory.createCars(names, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);

    }
}