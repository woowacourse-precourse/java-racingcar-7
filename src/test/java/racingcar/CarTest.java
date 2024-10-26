package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @Test
    void 움직일_수_있는_최소거리를_충족하지_못하면_자동차는_전진하지_않는다() {
        Car yh = new Car("yh");

        yh.moveForward(3);

        assertEquals(0, yh.currentLocation());
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4", "5,5", "6,6", "7,7", "8,8", "9,9"})
    void 자동차는_앞으로_갈_수_있다(int distance, int expected) {
        Car yh = new Car("yh");

        yh.moveForward(distance);

        assertEquals(expected, yh.currentLocation());
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