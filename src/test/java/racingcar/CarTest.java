package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    @DisplayName("canMove() 값이 참일 경우, 차가 움직인다")
    void moveTest() {
        Car car = new Car("testcar") {
            @Override
            boolean canMove() {
                return true;
            }
        };
        car.move();
        assertEquals(car.getDistance(), 1);
    }

    @Test
    @DisplayName("canMove() 값이 거짓일 경우, 차가 움직이지 않는다")
    void moveTest2() {
        Car car = new Car("testcar") {
            @Override
            boolean canMove() {
                return false;
            }
        };
        car.move();
        assertEquals(car.getDistance(), 0);
    }

    @Test
    @DisplayName("움직인 거리에 따른 실행 결과를 getStatus()로 출력한다.")
    void getStatusTest() {
        Car car = new Car("testcar");
        car.distance = 5;
        assertTrue(car.getStatus().startsWith("testcar : -----"));
    }
}
