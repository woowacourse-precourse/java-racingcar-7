package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 최대_위치와_같으면_TRUE를_반환한다() {
        //given
        RacingCar racingCar = new RacingCar("준수", 4);

        //when
        int maxPosition = 4;
        boolean actual = racingCar.isWinner(maxPosition);

        //then
        assertTrue(actual);
    }

    @Test
    void 최대_위치와_다르면_FALSE를_반환한다() {
        //given
        RacingCar racingCar = new RacingCar("준수", 4);

        //when
        int maxPosition = 5;
        boolean actual = racingCar.isWinner(maxPosition);

        //then
        assertFalse(actual);
    }

}