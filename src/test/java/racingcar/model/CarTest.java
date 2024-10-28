package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성시_기본_거리는_0이다(){
        Car car = getCar();
        assertEquals(0,car.getDistance());
    }

    @Test
    void 자동차는_랜덤값이_4이상일때_전진한다() {
        int random = 4;
        Car car = getCar();
        car.move(random);
        assertEquals(1, car.getDistance());
    }

    @Test
    void 자동차는_랜덤값이_3이하이면_정지한다() {
        int random = 3;
        Car car = getCar();
        car.move(random);
        assertEquals(0, car.getDistance());
    }

    private Car getCar() {
        String carName = "sun";
        return Car.getInstance(carName);
    }
}