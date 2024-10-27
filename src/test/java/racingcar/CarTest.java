package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차_이름이_정상적으로_입력된다")
    public void 자동차_이름이_정상적으로_입력된다() {
        String carName = "kim";
        Car car = new Car(carName);

        assertTrue(true);
    }

    @Test
    @DisplayName("자동차_이름이_6글자_이상으로_예외가_발생한다")
    public void 자동차_이름이_6글자_이상으로_예외가_발생한다() {
        String carName = "kimdevv";
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(carName);
        });
    }

    @Test
    @DisplayName("자동차를_한_번_앞으로_전진시킨다")
    public void 자동차를_한_번_앞으로_전진시킨다() {
        Car car = new Car("car");
        assertEquals(car.moveForward(), 1);
        assertEquals(car.moveForward(), 2);
        assertEquals(car.moveForward(), 3);
    }
}
