package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4 이상인 경우 이동")
    void moveTest() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi");
            car.move(4);
            assertEquals(1, car.getPosition());
        });
    }

    @Test
    @DisplayName("랜덤 숫자가 3 이하인 경우 이동하지 않음")
    void notMoveTest() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi");
            car.move(3);
            assertEquals(0, car.getPosition());
        });
    }
}