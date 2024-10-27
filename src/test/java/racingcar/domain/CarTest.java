package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static final int VALID_TRY_TIMES = 5;

    @Test
    void 생성자테스트() {
        Car car = new Car("pobi", VALID_TRY_TIMES);

        assertEquals("pobi", car.getName());
        assertEquals(VALID_TRY_TIMES, car.getReportCard().size());
    }

    @Test
    void 이름이_길면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("invalidname", VALID_TRY_TIMES));
    }

    @Test
    void 이름이_공백이면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("", VALID_TRY_TIMES));
    }

    @Test
    void 이름이_null이면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null, VALID_TRY_TIMES));
    }

    @Test
    void 시도횟수는_0이하면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("pobi", 0));
    }


}
