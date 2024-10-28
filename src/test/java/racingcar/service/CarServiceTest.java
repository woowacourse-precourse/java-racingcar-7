package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

    private CarService carService;
    private HashMap<String, Integer> cars;
    int attemptCount;

    @BeforeEach
    void setUp() {
        carService = new CarService();
        cars = new HashMap<>();
        attemptCount = 4;

        cars.put("A", 0);
        cars.put("B", 0);
        cars.put("C", 0);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void testUpdateCarLocationForward() {
        carService.updateCarLocation(cars, "A", true);

        assertEquals(1, cars.get("A"));
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void testUpdateCarLocationStop() {
        carService.updateCarLocation(cars, "B", false);

        assertEquals(0, cars.get("B"));
    }

    @Test
    @DisplayName("자동차 입력값을 HashMap으로 반환하는 메서드 테스트")
    void testSplitCarNames() {
        String input = "A,B,C";
        HashMap<String, Integer> result = carService.splitCarNames(input);

        assertEquals(cars, result);
    }
}
