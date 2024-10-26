package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성시_기본_거리는_0이다(){
        Car car = getCar();
        assertEquals(0,car.getDistance());
    }

    private Car getCar() {
        String carName = "sun";
        return Car.getInstance(carName);
    }
}