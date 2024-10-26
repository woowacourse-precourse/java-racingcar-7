package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_앞으로_갈_수_있다() {
        Car yh = new Car("yh");

        yh.moveForward(5);

        assertEquals(5, yh.currentLocation());
    }

    @Test
    void 자동차_이름이_5자를_초과하면_IllegalArgumentException이_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("javaji"));
    }

    @Test
    void 자동차는_이름을_가질_수_있다() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

}