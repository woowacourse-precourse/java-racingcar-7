package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 객체 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 객체가 생성된다.")
    void createsCarObject_When_CarNameIsValid() {
        String testCarName = "pobi";
        Car testCar = new Car(testCarName);
        assertEquals(testCar.getName(), testCarName);
        assertEquals(testCar.getPosition(), 0);
    }

    @Test
    @DisplayName("자동차가 전진하면 position 값이 1 증가한다.")
    void should_IncreasePositionByOne_When_MoveForwardIsCalled() {
        String testCarName = "pobi";
        Car testCar = new Car(testCarName);
        assertEquals(testCar.getPosition(), 0);
        testCar.moveForward();
        assertEquals(testCar.getPosition(), 1);
    }
}
