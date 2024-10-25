package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_이름(){
        //Given

        //when
        RacingCar racingCar = new RacingCar("USER");

        //then
        assertThat(racingCar.name).isSameAs("USER");
    }

    @Test
    void 자동차_전진(){
        //Given

        RacingCar racingCar = new RacingCar("USER");

        //when
        racingCar.moveForward();

        //then
        assertThat(racingCar.getMovedDistance()).isEqualTo(1);
    }
}