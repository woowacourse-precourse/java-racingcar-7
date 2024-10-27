package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStatusTest {
    @Test
    @DisplayName("차량이 앞에 있는지 확인")
    void test1() {
        CarStatus statusOne = new CarStatus(1);
        CarStatus statusZero = new CarStatus(0);

        assertTrue(statusOne.isAhead(statusZero));
        assertFalse(statusZero.isAhead(statusOne));
        assertFalse(statusOne.isAhead(statusOne));
    }

    @Test
    @DisplayName("차량 상태는 값 객체")
    void test2() {
        assertEquals(new CarStatus(1), new CarStatus(1));
    }
}