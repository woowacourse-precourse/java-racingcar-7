package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar");
    }

    @Test
    public void testInitialPosition() {
        assertEquals(0, car.getPosition(), "자동차 초기 위치는 0이어야 합니다.");
    }

    @Test
    public void testCarName() {
        assertEquals("TestCar", car.getCarName(), "자동차 이름이 생성자에서 전달한 이름과 일치해야 합니다.");
    }

    @Test
    public void testMove() {
        car.move();
        assertEquals(1, car.getPosition(), "자동차 이동 후 위치가 1이어야 합니다.");

        car.move();
        assertEquals(2, car.getPosition(), "자동차 이동을 두 번 호출하면 위치가 2이어야 합니다.");
    }
}
