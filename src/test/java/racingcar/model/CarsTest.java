package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;
    private final List<String> carList = List.of("pobi", "woni", "jun");

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차가 등록 테스트")
    void addCars() {
        cars.addCars(carList);
        assertEquals("pobi", cars.getCars().getFirst().getName());
        assertEquals("woni", cars.getCars().get(1).getName());
        assertEquals("jun", cars.getCars().getLast().getName());
    }
}