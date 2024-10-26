package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성시_기본_거리는_0이다(){
        String carName = "sun";
        Car car = Car.getInstance(carName);
        assertEquals(0,car.getDistance());
    }
}