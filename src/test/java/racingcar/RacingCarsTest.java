package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private final RacingCars racingCars = new RacingCars();

    @Test
    void 가장_멀리간_우승자의_이름을_반환한다() {
        //given
        RacingCar junsuCar = new RacingCar("준수", 5);
        RacingCar tobiCar = new RacingCar("토비", 3);
        racingCars.add(junsuCar);
        racingCars.add(tobiCar);

        //when
        List<String> winners = racingCars.getWinners();

        //then
        assertThat(winners).containsExactly(junsuCar.getName());
    }

    @Test
    void 위치가_같을_경우_우승자는_여러명이다() {
        //given
        RacingCar junsuCar = new RacingCar("준수", 5);
        RacingCar tobiCar = new RacingCar("토비", 5);
        racingCars.add(junsuCar);
        racingCars.add(tobiCar);

        //when
        List<String> winners = racingCars.getWinners();

        //then
        assertThat(winners).containsExactly(junsuCar.getName(), tobiCar.getName());
    }
}