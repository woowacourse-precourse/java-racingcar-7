package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("자동차 이름 생성")
    @Test
    void createCars() {
        // given
        String names = " pobi , woni , jun ";

        // when
        List<Car> cars = CarFactory.createCars(names);

        // then
        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
        assertEquals("jun", cars.get(2).getName());
    }


    @DisplayName("자동차 이름 생성 - 이름이 5자 초과 예외")
    @Test
    void createCarsOver5() {
        // given
        String names = " pobi , junjun ";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> CarFactory.createCars(names));
    }
}
