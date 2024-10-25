package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.number.TestableNumber;

class CarTest {
    private static final int MOVING_FORWARD = 5;
    private static final int STOP = 3;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("phobi");
    }

    @Test
    @DisplayName("유효한 객체 생성 테스트")
    void createCar() {
        assertEquals("phobi", car.getName().getCarName());
    }
    
    @Test
    @DisplayName("자동차가 전진 테스트")
    void MoveForward() {
        TestableNumber number = new TestableNumber(MOVING_FORWARD);

        car.goOrStop(number);

        assertEquals(1, car.getPosition().calculateMovingDistance());
    }

    @Test
    @DisplayName("자동차가 멈춤 테스트")
    void Stop() {
        TestableNumber number = new TestableNumber(STOP);

        car.goOrStop(number);

        assertEquals(0, car.getPosition().calculateMovingDistance());
    }
}
