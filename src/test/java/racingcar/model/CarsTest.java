package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    @DisplayName("Cars 생성 테스트")
    void testCreateCars() {
        List<String> names = List.of("pobi", "woni", "jun");
        List<Car> cars = Cars.createCars(names);

        assertEquals(3, cars.size());

        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
        assertEquals("jun", cars.get(2).getName());

        cars.forEach(car -> assertEquals(0, car.currentPosition()));
    }
}
