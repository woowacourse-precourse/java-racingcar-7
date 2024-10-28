package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ForwardMoveCondition;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("자동차들은 조건에 따라 전진,정지한다.(무조건 전진하는경우)")
    @Test
    void move() throws Exception{
        //given
        RacingCars racingCars = new RacingCars(List.of("car1", "car2", "car3"));
        //when
        racingCars.moveAll(new ForwardMoveCondition());
        //then
        List<Car> cars = racingCars.getCars();
        assertThat(cars)
                .extracting(Car::getPosition)
                .containsExactly(1, 1,1);
    }

    @DisplayName("우승자가 1명이상 있다.")
    @Test
    void getWinner() throws Exception{
        //given
        RacingCars racingCars = new RacingCars(List.of("car1", "car2", "car3"));

        //when
        List<Car> winners = racingCars.getWinners();

        //then
        assertThat(winners.size())
                .isGreaterThanOrEqualTo(1);
    }

}