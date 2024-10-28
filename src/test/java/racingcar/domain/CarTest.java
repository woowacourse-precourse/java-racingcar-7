package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car pobi;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi");
    }

    @DisplayName("차 이름을 반환한다.")
    @Test
    void getName() {
        String expectedName = "pobi";

        assertEquals(expectedName, pobi.getName());
    }

    @DisplayName("현재 위치를 반환한다.")
    @Test
    void getLocation() {
        int expectedLocation = 0;
        
        assertEquals(expectedLocation, pobi.getLocation());
    }

    @DisplayName("앞으로 전진한다.")
    @Test
    void plusLocation() {
        int expectedLocation = 1;

        pobi.plusLocation();

        assertEquals(expectedLocation, pobi.getLocation());
    }
}
