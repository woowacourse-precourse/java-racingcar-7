package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void 레이싱카는_한_칸씩_움직인다() {
        //given
        int position = 0;
        RacingCar racingCar = new RacingCar("준수", position);

        //when
        racingCar.move();

        //then
        assertThat(racingCar.getPosition()).isEqualTo(position + 1);
    }

}