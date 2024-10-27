package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("Car 생성 테스트")
    void testCarConstructor() {
        assertEquals("pobi", car.getName());
        assertEquals(0, car.currentPosition());
    }

    @Test
    @DisplayName("move 테스트")
    void testMoveIncrementsPosition() {
        car.move();
        assertEquals(1, car.currentPosition());

        car.move();
        assertEquals(2, car.currentPosition());
    }

    @Test
    @DisplayName("getName 테스트")
    void testGetName() {
        assertEquals("pobi", car.getName());
    }

    @Test
    @DisplayName("currentPosition 테스트")
    void testCurrentPosition() {
        assertEquals(0, car.currentPosition());

        car.move();
        assertEquals(1, car.currentPosition());

        car.move();
        assertEquals(2, car.currentPosition());
    }
}
