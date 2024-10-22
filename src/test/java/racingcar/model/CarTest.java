package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 객체_생성_테스트() {
        //given
        Car car = new Car("alex", 1);

        //then
        assertEquals(car.getName(), "alex");
        assertEquals(car.getPosition(), 1);
    }
}