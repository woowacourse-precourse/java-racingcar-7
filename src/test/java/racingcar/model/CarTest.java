package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CarTest {
    @Test
    void 차량_이름_콤마로_분리() {
        Car car = new Car("pobi,woni,jun");
        String[] carNames = {"pobi", "woni", "jun"};
        assertArrayEquals(carNames,car.getCarNames());
    }
}