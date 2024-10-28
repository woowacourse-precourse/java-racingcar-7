package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class WinnerManagerTest {
    @Test
    @DisplayName("자동차 List에서 최대 거리를 반환한다")
    void getMaxDistanceTest() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car1.setDistance(10);
        car2.setDistance(4);
        car2.setDistance(7);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        WinnerManager winnerManager = new WinnerManager();
        assertEquals(10, winnerManager.getMaxDistance(cars));
    }
}
