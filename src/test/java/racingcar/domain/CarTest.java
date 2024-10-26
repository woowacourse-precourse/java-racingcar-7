package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void 한번_전진() {
        Car testCar = Car.create("new");
        testCar.moveOrNothing(4);
        assertEquals(1, testCar.getMoveCnt());
    }

    @Test
    void 조건_충족_안돼서_그대로() {
        Car testCar = Car.create("no");
        testCar.moveOrNothing(3);
        assertEquals(0, testCar.getMoveCnt());
    }

}