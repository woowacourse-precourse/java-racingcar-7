package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {


    @Test
    void getName() {
        //given
        RacingCar racingCar = new RacingCar.Builder()
                .name("pobi")
                .position(0)
                .build();

        //when
        String name = racingCar.getName();

        //then
        assertThat(name).isEqualTo("pobi");
    }

    @Test
    void getPosition() {
        //given
        RacingCar racingCar = new RacingCar.Builder()
                .name("pobi")
                .position(0)
                .build();

        //when
        int position = racingCar.getPosition();

        //then
        assertThat(position).isEqualTo(0);
    }

    @Test
    void move() {
        //given
        RacingCar racingCar = new RacingCar.Builder()
                .name("pobi")
                .position(0)
                .build();

        //when
        racingCar.move();

        //then
        assertThat(racingCar.getPosition()).isBetween(0, 1);
    }
}