package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void 초기화() {
        car = new Car("TestCar");
    }

    @Test
    void Car_객체는_정상적으로_생성되어야_한다() {
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getMoveCount());
    }

    @Test
    void 이름을_올바르게_반환해야_한다() {
        assertEquals("TestCar", car.getName());
    }

    @Test
    void 초기_이동_횟수는_0이어야_한다() {
        assertEquals(0, car.getMoveCount());
    }

    @Test
    void move_메서드_호출_시_이동_횟수가_증가해야_한다() {
        car.move();
        assertEquals(1, car.getMoveCount());

        car.move();
        assertEquals(2, car.getMoveCount());
    }
}