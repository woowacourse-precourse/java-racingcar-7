package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsRegistrarTest {
    private CarsRegistrar carsRegistrar;

    @BeforeEach
    void setUp() {
        carsRegistrar = new CarsRegistrar();
    }

    @Test
    void 자동차_등록_확인() {
        Set<Car> expected = new HashSet<>();
        expected.add(new Car("BMW"));
        expected.add(new Car("Honda"));

        Cars cars = carsRegistrar.registerCars("BMW,Honda");
        Set<Car> actual = cars.getCars();

        assertEquals(expected, actual);
    }

    @Test
    void 자동차_중복_이름_유효검사() {
        assertThatThrownBy(() -> carsRegistrar.registerCars("BMW,BMW,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

}