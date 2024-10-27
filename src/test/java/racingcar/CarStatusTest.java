package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStatusTest {
    @Test
    @DisplayName("차량이 앞에 있는지 확인")
    void test1() {
        assertTrue(new CarStatus(1).isAhead(new CarStatus(0)));
        assertFalse(new CarStatus(0).isAhead(new CarStatus(1)));
        assertFalse(new CarStatus(1).isAhead(new CarStatus(1)));
    }

    @Test
    @DisplayName("차량 상태는 값 객체")
    void test2() {
        assertEquals(new CarStatus(1), new CarStatus(1));
    }

    @Test
    @DisplayName("차량 상태는 이동될 수 있음")
    void test3() {
        assertEquals(
                new CarStatus(10).moveForward(5),
                new CarStatus(10 + 5));
    }
}