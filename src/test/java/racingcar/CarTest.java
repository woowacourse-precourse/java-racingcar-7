package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("차량 전진 확인")
    void test1() {
        Car car = new Car("A", 5);

        car.move(10);

        assertEquals(car.getLocation(), 5 + 10);
    }

    @Test
    @DisplayName("차량이 다른 차량 앞에 있는지 확인")
    void test2() {
        assertTrue(new Car("A", 5).isAhead(new Car("A", 0)));
        assertFalse(new Car("A", 0).isAhead(new Car("A", 5)));
        assertFalse(new Car("A", 5).isAhead(new Car("A", 5)));
    }
}
