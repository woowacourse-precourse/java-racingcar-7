package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void 횟수_너무_많음_실패() {
        // given
        CarList carList = CarList.from("test1,test2,test3");
        int movingCount = 1000000000;
        Racing racing = new Racing(carList, movingCount);

        // when & then
        assertThrows(IllegalArgumentException.class, racing::start);
    }

}