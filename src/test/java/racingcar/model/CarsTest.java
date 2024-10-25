package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("pobi", "jun", "kiki"));
    }

    @Test
    @DisplayName("모든 자동차의 초기 위치가 0이다.")
    void carsInitPosition() {
        Map<String, Integer> positions = cars.getCarPositions();
        assertEquals(0, positions.get("pobi"));
        assertEquals(0, positions.get("jun"));
        assertEquals(0, positions.get("kiki"));
    }

    @Test
    @DisplayName("자동차의 위치가 정상적으로 업데이트 된다.")
    void updateCarPosition() {
        cars.updateCarPosition("pobi");

        Map<String, Integer> positions = cars.getCarPositions();
        assertEquals(1, positions.get("pobi"));
        assertEquals(0, positions.get("jun"));
        assertEquals(0, positions.get("kiki"));
    }

    @Test
    @DisplayName("여러 자동차의 위치가 정상적으로 업데이트 된다.")
    void multipleUpdateCarPosition() {
        cars.updateCarPosition("pobi");
        cars.updateCarPosition("kiki");

        Map<String, Integer> positions = cars.getCarPositions();
        assertEquals(1, positions.get("pobi"));
        assertEquals(0, positions.get("jun"));
        assertEquals(1, positions.get("kiki"));
    }

}
