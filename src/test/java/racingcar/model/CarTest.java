package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void 테스트_객체_생성() {
        car = new Car("alex", 0);
    }

    @Test
    void 객체_생성_테스트() {
        //then
        assertEquals(car.getName(), "alex");
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void 파라미터_4이상_전진_테스트() {
        //given
        int four = 4;
        int nine = 9;

        //when
        car.go(four);
        car.go(nine);

        //then
        assertEquals(car.getPosition(), 2);
    }

    @Test
    void 파라미터_4미만_전진_테스트() {
        //given
        int three = 3;
        int zero = 0;

        //when
        car.go(three);
        car.go(zero);

        //then
        assertEquals(car.getPosition(), 0);
    }
}