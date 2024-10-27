package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void set() {
        car = Car.of("pobi");
    }

    @Test
    void 차_이름이_맞는지_테스트() {
        String expectedName = "pobi";

        assertEquals(car.getName(), expectedName);
    }

    @Test
    void 초기_생성된_자동차의_거리가_0인지_테스트() {
        Car car = Car.of("pobi");
        int expectedPosition = 0;

        assertEquals(car.getPosition(), expectedPosition);
    }

    @Test
    void 차가_이동_후_거리도_증가하는지_테스트() {
        Car car = Car.of("pobi");
        int expectedPosition = 1;

        car.move(5);

        assertEquals(car.getPosition(), expectedPosition);
    }

    @Test
    void 랜덤한_값이_4이상이_아닌_경우() {
        Car car = Car.of("pobi");
        int expectedPosition = 0;

        car.move(1);

        assertEquals(car.getPosition(), expectedPosition);
    }
}