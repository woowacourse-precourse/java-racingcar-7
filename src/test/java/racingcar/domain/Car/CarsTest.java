package racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        String[] initialCars = {"pobi", "woni", "crong"};
        cars.addCar(initialCars);
    }

    @Test
    void testValidateDuplicateName() {
        // given
        String[] duplicateNames = {"pobi", "pobi"};

        // when & then
        assertThatThrownBy(() -> cars.addCar(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
