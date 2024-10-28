import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;


public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 자동차가 전진")
    void testCarMovesForward() {
        car.move(4);  // 무작위 값을 4로 설정하여 전진 여부 확인
        assertEquals(1, car.getPosition());

        car.move(5);  // 무작위 값을 9로 설정하여 전진 여부 확인
        assertEquals(2, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 3 이하일 경우 자동차가 멈춤")
    void testCarDoesNotMove() {
        car.move(3);  // 무작위 값을 3으로 설정하여 멈춤 여부 확인
        assertEquals(0, car.getPosition());

        car.move(2);  // 무작위 값을 2로 설정하여 멈춤 여부 확인
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차의 초기 위치가 0인지 확인")
    void testInitialPosition() {
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 설정되는지 확인")
    void testCarName() {
        assertEquals("testCar", car.getName());
    }

    @Test
    @DisplayName("자동차의 위치를 문자열로 표현")
    void testToString() {
        car.move(4);  // 자동차가 전진하여 위치를 업데이트
        assertEquals("testCar : -", car.toString());

        car.move(4);  // 자동차가 다시 전진해 위치를 업데이트
        assertEquals("testCar : --", car.toString());
    }
}