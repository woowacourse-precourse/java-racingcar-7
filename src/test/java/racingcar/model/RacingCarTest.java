package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCarTest(){
        String carName = "car1";
        RacingCar racingCar = new RacingCar(carName);
        racingCar.moveForward();
        racingCar.moveForward();
        racingCar.moveForward();
        assertEquals(3,racingCar.getCurrentPosition());
    }
}
