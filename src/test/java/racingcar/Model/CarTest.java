package racingcar.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("pobi");
        car.move(4); // 4 이상일 때 이동
        assertEquals(1, car.getPosition());

        car.move(3); // 3 이하일 때 이동 안 함
        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_이름_설정_테스트() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
    }
}